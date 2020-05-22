int widthIndex = 90;
    int hightIndex = 100;
    int indiceLatime = 0;
    boolean lookForWidth = true;

    try {
        BufferedReader br = new BufferedReader(new FileReader("table.txt"));
        String line = "";
        while ((line = br.readLine()) != null) {

            String[] aux = line.split(",");

            if(lookForWidth) {// this flag to look for width only at the first time.
                for (int i = 0; i < aux.length; i++) {
                    if(widthIndex == Integer.parseInt(aux[i].trim())) {
                        indiceLatime = i;
                        lookForWidth = false;
                        continue;
                    }
                }
            }

            for (int i = 0; i < aux.length; i++) {
                if(hightIndex == Integer.parseInt(aux[0])) {
                    System.out.println(aux[indiceLatime]);
                    break;
                }
            }
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }