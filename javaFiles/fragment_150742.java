double[][] doubles = new double[10][10];
for(double[] ds : doubles)
    for(int i=0;i<ds.length;i++)
        ds[i] = Math.random() * 100;

PrintWriter pw = new PrintWriter("double.tsv");
for(double[] ds : doubles) {
    for(double d: ds)
        pw.printf("%.6f\t", d);
    pw.println();
}
pw.close();

BufferedReader br = new BufferedReader(new FileReader("double.tsv"));
String line;
while((line = br.readLine())!=null) {
    String[] words = line.split("\t");
    for (String word : words) {
        double d = Double.parseDouble(word);
        System.out.print(d+"\t");
    }
    System.out.println();
}