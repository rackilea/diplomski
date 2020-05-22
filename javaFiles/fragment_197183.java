List currentList = null;

public void setCurrentList(String listName) { // you can use integer but the best is to use enum type setCurrentList(enum) this way you will get tapeSafety
     switch(listName){
        case "ingredients" : currentList = ingredients ; break;
        //other cases 
        default : throw new Exception(" list not referred error with key value"+listName);
     }
}

public void delete(Object o){
     int index = this.currentList.indexOf(o);
     this.currentList.remove(index);
}