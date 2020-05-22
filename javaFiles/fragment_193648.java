public static final String[][] myArray = {
        {"NM1", "DESC1"},
        {"NM2", "DESC2"},
        {"NM3", "DESC3"},
        {"NM4", "DESC4"},
        {"NM5", "DESC5"}
    }

List<String[]> list = Arrays.asList(myArray);
for(String[] arr: list){
    System.out.println(Arrays.asList(arr).contains("myString"));
}