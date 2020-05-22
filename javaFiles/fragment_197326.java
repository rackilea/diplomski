private Table1 t1;

public Table(Table1 t1, int sID, String sName, String sDate, Integer sPrice) {
    this.rID = new SimpleIntegerProperty(sID);
    this.rName = new SimpleStringProperty(sName);
    this.rDate = new SimpleStringProperty(sDate);
    this.rPrice = new SimpleIntegerProperty(sPrice);
    this.t1 = t1;
}
//Add this
public String getName(){
    return t1.getName();
}
//Add this
public String getSurname(){
    return t1.getVorname();
    //Bist Du Deutscher? :D
}