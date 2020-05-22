Olive found;
for(Olive olive : olives) {
    if(olive.name.equals("Ligurian")) {
        found = olive;
        break;
    }
}
String origin = found.getOrigin();