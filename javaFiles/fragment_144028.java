for (int i=0; i<(myList.getCount()/2); i++){
    Log.v("Line " + i, myList.getItem(i).getWeekNo() + "|" + 
        myList.getItem(i).getDesc() + ":" + myList.getItem(i).getAmount() + "|" + 
        myList.getItem(mylist.getCount()/2 + i).getDesc() + ":" + 
            mylist.getItem(myList.getCount()/2 + i).getAmount();
}