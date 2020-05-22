File file = new File("file.txt");
FileReader reader = new FileReader(file);
BufferedReader r = new BufferedReader(reader);

String[][] stats = new String[10][];
String line;
int index = 0;
while ((line = r.readLine()) != null && index < 10)
stats[index++] = line.split(",");

// sort based on the first column
for (int i = 0; i < stats.length; ++i)
    for (int j = i + 1; j < stats.length; ++j)
        if (stats[i][0].compareTo(stats[j][0]) > 0) {
            // swap
            String[] temp = stats[i];
            stats[i] = stats[j];
            stats[j] = temp;
        }
for(int i=0;i<stats.length;++i){
    for(int j=0;j<stats[i].length;++j)
        System.out.print(stats[i][j] + " ");
    System.out.println();
}