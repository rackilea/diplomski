public class Grid {
    private List<List<obj>> objs = new ArrayList<List<obj>>();
    public void addObj( Obj obj, int x, int y) {
        objs.get(x).set(y,obj);
    }
}