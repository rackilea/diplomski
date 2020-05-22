class Data {
    final int id;
    final String name;
    final int testN;
    final String type;
    final float testF;
    // here you can use any other date type you like
    final LocalDateTime testD; 

    Data(int id, String name, int testN, String type, float testF, LocalDateTime testD) {
        this.id = id;
        this.name = name;
        this.testN = testN;
        this.type = type;
        this.testF = testF;
        this.testD = testD;
    }
 }