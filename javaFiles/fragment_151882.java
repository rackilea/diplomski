private void getProductsFromFile() {
    try {
        BufferedReader br = new BufferedReader(new FileReader(new File("path/to/file.txt"));
        String line;
        String[] array;

        while ((line = br.readLine()) != null){
            array = line.split(" ");
            table.getItems().add(new Product(Integer.parseInt(array[0]), Integer.parseInt(array[1]), Integer.parseInt(array[2])));
        }

        br.close();

    }catch (Exception ex){
        ex.printStackTrace();
    }
}