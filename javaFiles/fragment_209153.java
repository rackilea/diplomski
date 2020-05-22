List<String[]> tempArr = new ArrayList<String[]>(Arrays.asList(pass));
//Remove row at index of "delete_name":
for(int i = 0; i < pass.length; i++){
  if(pass[i][0].equals(delete_name)){
    tempArr.remove(i);
  }
}
String[][] new_array = tempArr.toArray(new String[][]{});