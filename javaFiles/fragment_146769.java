List<Ingredient> data = new ArrayList<>();
try {
    String sCurrentline = null;
    BufferedReader br = new BufferedReader(new FileReader("/sdcard/MAIN_BF.csv"));
    while ((sCurrentline = br.readLine()) != null) {
        String[] arr = sCurrentline.split(",");
        Ingredient ingredient = new Ingredient(arr[0], arr[1], arr[2], arr[3]);
        data.add(ingredient);
    }
    br.close();
} catch (IOException e) {
    e.printStackTrace();
}