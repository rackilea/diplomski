List newlist; // make sure all of your various List types are compatible. 
switch (type){
    case "unsorted":    
    {
        newList = new UnsortedList();
        break;
    }
    case "sorted":      
    {
        newList = new SortedList();
        break;
    }
    case "new sorted":  
    {
        newList = new NewSortedList();
        break;
    }

    default:
    {
        System.out.print("Something went wrong! List type unrecognized. I have initialized newList to be an unsorted list.");
        newList = new UnsortedList();
    }
}