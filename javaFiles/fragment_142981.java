class myClass {
    String[] str;

    void A() {
        int size = field1 + field2;
        str = new String[size];
    }

    void B() {
        if( str == null ) return;
        // else use str
    }
}