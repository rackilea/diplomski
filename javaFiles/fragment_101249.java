private InfoDao infoDao; // This is a class that gets the data; it's a member of the class with the onBackPressed() method

public void onBackPressed() {
    Info info = this.infoDao.find();
    if (info != null) {
        displayInfo();
    }
}