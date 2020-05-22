public boolean CheckForNumber(String number){
                Cursor c = sdb.rawQuery("select * from callContactList where cname = " + number, null);
                int numRows = c.getCount();
                if(c!=null) {
                    return true;
                } else {
                    reutrn false 
                }
}