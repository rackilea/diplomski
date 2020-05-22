String[] strings = new String[combined2d.size()];

for (int i = 0; i < combined2d.get(0).size(); i++){

   for (int j = 0; j < combined2d.size(); j++){
      strings[j] = combined2d.get(j).get(i);
   }

   FuncA(strings[0] strings[1], strings[2]);
}