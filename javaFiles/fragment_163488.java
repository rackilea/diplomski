public setMyDate(String myDate)
{
    try{
        this.MyDate = format.parse(myDate); //should be this.myDate = ...
    } Catch(Exception e) {
        e.printStackTrace();
    }
}