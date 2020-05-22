public static void main(String[] args) throws FileNotFoundException {

    String line;
    int x=0;
    String [] cName = new String [100];
    String [] cMascot = new String [100];
    String [] cAlias = new String [100];

    try (BufferedReader input = new BufferedReader(new FileStreamReader("test.txt"))) {

         while ((line = input.readLine())!=null) {

             cName[x] = line.split(",")[0];
             cMascot[x] = line.split(",")[1];
             cAlias[x] = line.split(",")[2];
             x++;
         }
    }

}