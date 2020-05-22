public class CowWrapper {
    public boolean[]cow;
    public CowWrapper(boolean[]cow){
        this.cow=cow;
    }
}
public void moo() {
    CowWrapper cow=new CowWrapper(new boolean[10]);
    baa(cow);
    assertNull(cow.cow);
}
public void baa(CowWrapper sheep) {
    sheep.cow=null;
}