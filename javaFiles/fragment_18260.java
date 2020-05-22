String [][] array = new String[2][2];
array[1][1] = "desperate";
array[0][1] = "despee";
array[1][0] = "despete";
array[0][0] = "dete";

for (String[] innerArr: array) {
    for (String value: innerArr) {
         if (value.equals("desperate")) {
             System.out.println(value + " == desperate");
         }
    }
}