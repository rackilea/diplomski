PrintWriter fout = new PrintWriter(new BufferedWriter(
    new FileWriter("numbers.dat")
)); 

String sep = "";
for(int i = start; i <= 100; i += 2) { 
    fout.print(sep + i);
    sep = ", ";
}