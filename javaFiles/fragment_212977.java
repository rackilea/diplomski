for f in `find *.vc`; do

 fn=`echo $f | cut -d'.' -f1`;
 echo "Processing ... $f";

 java VC.vc $f
 java jasmin.Main $fn.j
 java $fn

done;