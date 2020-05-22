public static void main(String[] args) throws IOException {
        OutputStream output = new FileOutputStream ("converteddata.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File("data.txt")));
        String r = null;
        while((r=br.readLine())!=null) {
            String [] str = r.split("-");
            for (String string : str) {
                Long l = Long.parseLong(string.trim(), 16);
                output.write(String.valueOf(l).getBytes());
                output.write("\n".getBytes());
            }

        }
        br.close(); 
        output.close();

    }