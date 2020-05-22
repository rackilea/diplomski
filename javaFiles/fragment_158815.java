@BeforeClass
public static void setUpClass() {
    WebInOutTrx temp=new WebInOutTrx();
    temp.setSndrName("Abc");
    temp.setNoteToBnf("Abc Bnf addr");
    temp.setSndrPhone("Abc phone");
    temp.setEntryUser("Abc Entry USer");
    temp.setSndrAdd("Abc Sndr Addr");
    webInOutList.add(temp);
    //Missing in your code
    WebInOutTrx temp=new WebInOutTrx();
    //End Missing
    temp.setSndrName("Abc");
    temp.setNoteToBnf("Abc Bnf addr1");
    temp.setSndrPhone("Abc phone1");
    temp.setEntryUser("Abc Entry USer1");
    temp.setSndrAdd("Abc Sndr Addr1");
    webInOutList.add(temp);                                   
}