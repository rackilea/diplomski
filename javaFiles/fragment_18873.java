public void deleteList(ArrayList listToRemove){
    listToRemove = null;
}

public void chooseListToRemove(int listNumber){
    if (listNumber == 1){
        deleteList(list1);
    }
    else if (listNumber == 2){
        deleteList(list2);
    }
    else if (listNumber == 3){
        deleteList(list3);
    }
}