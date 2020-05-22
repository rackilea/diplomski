public void test() {
    list=new ArrayList<String>(); 
    list.add("1");
    list.add("2");
    list.add("3");
    Testing t=new Testing(); 
    t.testmtd(this);     // Pass this object
    System.out.println(list);
}