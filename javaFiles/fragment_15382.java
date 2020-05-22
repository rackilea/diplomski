public void capitalize(String[] name) {
  String s = "";
  for (int i = 0; i < name.length; i++) {
     s = name[i];
     s = s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
     name[i] = s;
  }                    
}