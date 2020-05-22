PrintWriter fout = new PrintWriter(new BufferedWriter(
    new FileWriter("numbers.dat")
)); 

for(int i = start; i <= 100; i += 2) { 
    fout.print((i == start ? "" : ", ") + i);
}