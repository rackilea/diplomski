public class ControllerOfMine{

    private List<B> bs;

    public List<B> remove(List<A> as){
        if (as.isEmpty()) return bs;

        HashSet<A> quickLookup = new HashSet<A>();
        quickLookup.addAll(as);
        List<B> result = new ArrayList<B>();
        for (B b: bs) {
          if (!quickLookup.contains(b.getA())) {
            result.add(b);
          }
        }
        return result;
    }
}