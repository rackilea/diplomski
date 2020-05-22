public static void main(String[] args) {

        int[][] studentScores = new int[93][15];

        float[] studentGPA = new float[93];

        String fileName = "Students.txt";

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            int studentIndex = 0;
            String[] lineSplit;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                lineSplit = line.split(",");
                for (int k = 0; k < 15; k++) {
                    studentScores[studentIndex][k] = Integer.parseInt(lineSplit[3 + k]);
                }
                studentGPA[studentIndex] = Float.parseFloat(lineSplit[lineSplit.length - 1]);
                studentIndex++;
            }
        } catch (IOException ex) {
            System.out.println("error");
        }

    }