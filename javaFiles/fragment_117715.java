int i = 0;
String[] tab = {"Eva", "Ali", "David", "Maxime"};
String[] other = new String[tab.length];

for(String elt : tab){
    if(elt.length() > 4){
        other[i++] = elt;
    }
}
for(String elt : other){
    System.out.println(elt);
}