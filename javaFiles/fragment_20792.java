static List<String> columnNames(int n) {
    List<String> result = new ArrayList<String>();

    String alphabets[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    StringBuilder sb = new StringBuilder();
    for(int j = 0; j < n; j++){
        int index = j/26;   
            char ch = (char) (j % 26 + 'A');               
          sb.append(ch);
          String item = "";
          if(index > 0) {
              item += alphabets[index-1];
          }
          item += alphabets[j % 26];
          result.add(item);
    }
    sb.reverse();
    return result;
}