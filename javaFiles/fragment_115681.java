private static File file;
private static BufferedReader counterReader = null;
private static BufferedReader fileReader = null;

public static void main(String[] args) {
    try {
        file = new File("C:\\Users\\rohitd\\Desktop\\NRLdata.txt");
        counterReader = new BufferedReader(new FileReader(file));
        int numberOfLine = 0;
        String line = null;
        try {
            while ((line = counterReader.readLine()) != null) {
                numberOfLine++;
            }

            String[][] storeAnswer = new String[9][numberOfLine];
            int counter = 0;

            fileReader = new BufferedReader(new FileReader(file));

            while ((line = fileReader.readLine()) != null) {
                String[] temp = line.split(",");
                for (int j = 0; j < temp.length; j++) {
                    storeAnswer[j][counter] = temp[j];
                    System.out.println(storeAnswer[j][counter]);
                }
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    catch (FileNotFoundException e) {
        System.out.println("Unable to read file");
    }
}