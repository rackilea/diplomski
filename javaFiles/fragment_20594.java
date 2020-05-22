String st;
    BufferedReader Br = null;
    File objFile = new File("C:\\data\\file.txt");
    Br = new BufferedReader(new FileReader(objFile));
    while ((st = Br.readLine()) != null) {
        String value = st.replace("\"", "");
        String[] arraylist = value.split(",");                     
        for (String row : arraylist) {
            System.out.println(row);
        }
    }                   
    Br.close();