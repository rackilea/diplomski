public class Test {
    public Memory[] memlist;

    public void memPass(Memory[] memLocList) {
        memList = memLocList;
    }

    public void accessArray(int mem) {
        int someInt = memList[mem].getSomething();
    }
}