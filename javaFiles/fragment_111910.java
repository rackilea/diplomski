String find(){
   for (int i=0; i<list.size(); i++){
        if (list.get(i).isGood()) {
            return list.get(i);
        }
    }
    return null;
}