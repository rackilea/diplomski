public static void main(String[] args) {

        BufferedReader br = null;
        try {
            String sCurrentLine;
//          br = new BufferedReader(new FileReader("D:\\test.txt")); //Absolute File
            br = new BufferedReader(new FileReader("test.txt"));//Relative File
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }