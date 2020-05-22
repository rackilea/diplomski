Process p = Runtime.getRuntime().exec("gnuplot --persist");

BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
String s = "plot '-' title 'Spectogram' w image\n";
writer.write(s);
writer.flush();

for(int m = 0; m < x.length; m++){
   for(int k = 0; k < x[0].length; k++){
       s = m + " " + k + " " + x[m][k] + "\n";
       writer.write(s);  
       writer.flush();
   }
}

s = "e\n";
writer.write(s);
writer.flush();