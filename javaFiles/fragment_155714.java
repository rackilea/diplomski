try {

        String str;
                    String[] temp;

        BufferedReader br = new BufferedReader(new FileReader("your filepath"));

        while ((str= br.readLine()) != null) {
                            temp = str.split(";"); // seperator words bye;
            System.out.println(str);
                    for(int i = 0; i<temp.lenght; i++)
                            System.out.println(temp[i]);
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