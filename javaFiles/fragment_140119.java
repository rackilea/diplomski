public String getRoomDescription(){
    StringBuilder sb = new StringBuilder("Rooms contains :");
    for(Item i : items){
         sb.append("\n".append(i.getLongDescription());
    }
    return sb.toString();
}