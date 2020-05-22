String string = "01100001100001100110000110000";
String[] array = string.split("(?<=\\G.{7})");
String[] array2= new String[array.length*2];

  for(int i = 0; i < array.length; i++) {
    String[] temp = array[i].split("(?<=\\G.{4})");
    array2[i*2] = temp[0];
    if (temp.length > 1) {
        array2[i*2+1]= temp[1];
    }
  }