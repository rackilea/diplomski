#!/bin/bash

# Remove any edges generated in previous runs of this script
rm *_[NESW]*png 2> /dev/null
rm *_[NESW]*txt 2> /dev/null

DEBUG=1

# Process all PNGs
for f in *.png; do

   echo "Processing $f ..."

   # Get basename of image
   base=$(basename -s .png "$f")

   # Get width and height - not actually used at the moment
   read w h <<< $(identify -format "%w %h" "$f")
   [ $DEBUG -gt 0 ] && echo "   width:$w"
   [ $DEBUG -gt 0 ] && echo "   height:$h"

   # Extract North edge
   convert "$f" +repage -crop x1+0+0 +repage "${base}_N.png"
   [ $DEBUG -gt 0 ] && echo "   North edge extracted"

   # Extract East edge
   convert "$f" +repage -gravity east -crop 1x+0+0 -rotate 90 +repage "${base}_E.png"
   [ $DEBUG -gt 0 ] && echo "   East edge extracted"

   # Extract South edge
   convert "$f" +repage -gravity south -crop x1+0+0 +repage "${base}_S.png"
   [ $DEBUG -gt 0 ] && echo "   South edge extracted"

   # Extract West edge
   convert "$f" +repage -gravity west -crop 1x+0+0 -rotate 90 +repage "${base}_W.png"
   [ $DEBUG -gt 0 ] && echo "   West edge extracted"

   # Test if corner or edge piece
   n=0
   for edge in N E S W; do
      name="${base}_${edge}.png"
      min=$(identify -format "%[min]" "$name")
      if [ $min -gt 0 ]; then
         ((n++))
         e=$name
      fi
   done
   [ $n -eq 1 ] && echo "   $e is edge-piece"
   [ $n -eq 2 ] && echo "   $name is corner-piece"
done

EDITED FROM HERE ---
# Now convert all edges to text, forwards and backwards to allow rotation
for f in *_[NESW].png; do
   base=$(basename -s png "$f")
   # Convert to PBM format, remove 2 header lines and make into one line string
   str=$(convert "$f" -compress none pbm: | sed "1,2d" | tr -d "\n ")
   echo "$str:$f"
   str=$(rev <<< $str)
   echo "$str:$f (flipped)"
done | sort