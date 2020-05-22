while ( i < list.get(LowerCaseCh).size()-1) {
  String []arr = ((String)list.get(LowerCaseCh).get(i)).split ("\\t");
  surname[i] = arr[0];
  in[i] = arr[1];
  ext[i] = arr[2];
  i++;
}