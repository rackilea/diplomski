#!/bin/bash

#USAGE ./swf2svg.sh /path/to/file.swf > output.svg

FILE=$1;
DUMP="dump.txt"

echo '<?xml version="1.0" standalone="no"?>
<!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN"
"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd">

<svg width="100%" height="100%" version="1.1"
xmlns="http://www.w3.org/2000/svg">

';

swfdump -s $FILE > $DUMP

fillCols=();
lineCols=();
lineWidth=();

FILLREGEX="[0-9]+(\s*)SOLID [0-f]{8}";
LINEREGEX="[0-9]+(\s*)[0-9]\.[0-9]{0,2} [0-f]{8}";

lastStartPoint="";
pathClosedTag="";
firstGroup="TRUE";
firstPath="TRUE";

cat $DUMP | while read line 
do
   #Remove ( and )
   line=`echo $line | sed "s/[()]//g"`

   #tmp=`echo $line | egrep -o "DEFINE(SHAPE|SPRITE)"`;
   tmp=`echo $line | egrep -o "DEFINE(SHAPE|SPRITE)[0-9]? defines id [0-9]+"`;

   if [ "$tmp" !=  "" ]
   then
      if [ "$firstGroup" == "TRUE" ]
      then
         firstGroup="FALSE";
      else
         if [ "$firstPath" == "FALSE" ]
         then
            if [ "$lastStartPoint" != "" ]
            then
               if [ "$lastStartPoint" == "$curPoint" ]
               then
                  pathClosedTag="Z";
               fi
            fi

            lastStartPoint=$curPoint;
            echo $pathClosedTag'" />';
         fi;
         firstPath="TRUE";
         echo '</g>';
      fi

      id=`echo $tmp | awk {'print $4'}`

      echo '<g id="'$id'">';
      fillCols=();
      lineCols=();
      lineWidth=();
   fi

   tmp=`echo $line | egrep -o  "($FILLREGEX)?((\s*)$LINEREGEX)?"`;
   if [ "$tmp" !=  "" ]
   then
      fillInx=`echo $tmp | egrep -o  "$FILLREGEX" | awk {'print $1'}`;
      fillCol=`echo $tmp | egrep -o  "$FILLREGEX" | awk {'print $3'}`;

      if [ "$fillCol" != "" ] 
      then
         fillCols[$fillInx]=$fillCol;
      fi

      lineInx=`echo $tmp | egrep -o  "$LINEREGEX" | awk {'print $1'}`;
      lineWth=`echo $tmp | egrep -o  "$LINEREGEX" | awk {'print $2'}`;
      lineCol=`echo $tmp | egrep -o  "$LINEREGEX" | awk {'print $3'}`;
      if [ "$lineCol" != "" ] 
      then
         lineCols[$lineInx]=$lineCol;
         lineWidth[$lineInx]=$lineWth;
      fi
   fi

   tmp=`echo $line | awk {'print $6'}`;

   if [ "$tmp" ==  "lineTo" ]
   then
      echo $line | awk {'print "L"$7" "$8'}
   fi

   if [ "$tmp" ==  "moveTo" ]
   then

      curPoint=`echo $line | awk {'print $9" "$10'}`;

      if [ "$lastStartPoint" != "" ]
      then
         if [ "$lastStartPoint" == "$curPoint" ]
         then
            pathClosedTag="Z";
         fi
      fi

      lastStartPoint=$curPoint;

      if [ "$firstPath" == "TRUE" ]
      then
         firstPath="FALSE";
      else
         echo $pathClosedTag'" />';
      fi;

      #Remove : and /
      line=`echo $line | sed "s/[:/]/ /g"`

      fInx=`echo $line | awk '{printf "%d", $4}'`;
      lInx=`echo $line | awk '{printf "%d", $6}'`;

      stl="";
      val=${fillCols[$fInx]:0:6};
      if [ $fInx -gt 0 -a "$val" != "" ]
      then
         stl="fill:#$val;";
      fi

      val=${lineCols[$lInx]:0:6};
      if [ $lInx -gt 0 -a "$val" != "" ]
      then
         stl=$stl"stroke:#$val;";

         val=${lineWidth[$lInx]};
         if [ "$val" != "" ]
         then
            stl=$stl"stroke-width:$val;";

         fi
      fi

      echo '<path style="'$stl'" d="';
      echo $line | awk {'print "M"$9" "$10'}
   fi

   if [ "$tmp" ==  "splineTo" ]
   then
      echo $line | awk {'print "Q"$7" "$8" "$9" "$10'}
   fi

done
echo 'Z" />';
echo '</g>';
echo '</svg>';