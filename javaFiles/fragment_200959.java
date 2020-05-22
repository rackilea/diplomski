public class Test {
    public List<Memory> memlist;

    public void memPass(Memory[] memLocList) {
        memlist = new ArrayList<Memory>(Arrays.asList(memLocList));
    }

    public void accessArray(int mem) {
        int someInt = memList.get(mem).getSomething();
    }
}