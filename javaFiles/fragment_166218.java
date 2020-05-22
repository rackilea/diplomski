PrintWriter fout = new PrintWriter(new BufferedWriter(
    new FileWriter("numbers.dat")
));

StringBuffer buffer;

for(int i = start; i <= 100; i += 2) { 
    buffer.append(i == start ? "" : ", ").append(i);
}

fout.print(buffer);