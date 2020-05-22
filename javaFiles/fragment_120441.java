for (int i = 0; i < list.size() - 1; i++){
    if (list.get(i).compareTo(list.get(i + 1)) < 0){
         sorted = true;
    }
    else {
         return false;
    }
}