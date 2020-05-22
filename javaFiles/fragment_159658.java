public static void main(String[] args) {
    ArrayList<MyDataObject> a = new ArrayList<MyDataObject>();

    for(int x=0;x<5;x++){
        MyDataObject myl = new MyDataObject("asdasd", Integer.toString(x));
        a.add(myl);
    }

    int aSize = a.size();
    Object[][] thingy = new Object[aSize][2];
    for(int i = 0; i < aSize; i++) {
        MyDataObject mdo = a.get(i);
        thingy[i][0] = mdo.getS();
        thingy[i][1] = mdo.getI();
    }
}