BufferedReader br = new BufferedReader(new FileReader("D:\\sample.txt"));
    String st = null;
    String[] animal = new String[10];
    String[] species = new String[10];
    String[] lives = new String[10];
    int j = 0;
    while ((st = br.readLine()) != null) {
        String[] str = st.split(",");

        for (int i = 0; i < str.length; i++) {
            animal[j] = str[0];
            species[j] = str[1];
            lives[j] = str[2];
        }
        j++;
    }