public static void main(String[] args) {
    String json = "[ [\"cd\",5,6,7], [\"rtt\",55,33,12], [\"by65\",87,87,12] ]";
    List<CustomClass> customList = new ArrayList<CustomClass>();
    String[][] data = new Gson().fromJson(json, String[][].class);
    for (String[] strArray : data){
        customList.add(new CustomClass(strArray[0], 
                Integer.parseInt(strArray[1]), 
                Integer.parseInt(strArray[2]), 
                Integer.parseInt(strArray[3])));
    }
    System.out.println(customList);
}