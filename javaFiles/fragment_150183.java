public int searchContactName(String name){

    int foundIndex =-1;
    for (int i = 0; i < contacts.size(); i++){
        if (contacts.get(i).getName().equals(name)) { // here!
            foundIndex = i;
        }
    }

    return foundIndex;
}