public static Plan[] createDummyData(){
    String[] names = {"abc", "stu", "vwx", "yza", "bcd"};
    Plan[] p = new Plan[5];

    for(int x=0; x<p.length; x++)
        p[x] = new Plan(names[x]);

    p[0].setColumn("product1", 0);
    p[3].setColumn("product2", 0);
    p[4].setColumn("product3", 0);
    p[4].setColumn("product4", 2);      
    return p;       
}