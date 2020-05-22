public static void main(String[] args) {

        BufferedReader br = null;

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("secretwords.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine.replaceAll("SECRET", ""));

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