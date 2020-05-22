public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("file.txt"));

        try {

            String line = br.readLine();
            List<String> splitStr = new ArrayList<String>();

            while (line != null) {
                splitStr.addAll(Arrays.asList(line.split("\\s+")));
                line = br.readLine();
            }

            System.out.println(splitStr);

        } finally {
            br.close();
        }
    }