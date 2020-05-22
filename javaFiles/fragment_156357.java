private ArrayList<ConnectionsModel> mData;

public onClick() { 
    // do clear data and notify it (from ListView), how?! 
    clearData();
} 

public void clearData() {
    mData.clear();
    // do something else here if you want.  Like some kind of visual notification to the user
    notifyDataSetChanged();
}