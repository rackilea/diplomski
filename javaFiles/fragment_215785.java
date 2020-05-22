public class Panel{

    public static Iterable<Integer> panel1(final int begin,final int end){
        return new Iterable<Integer>() {
            public Iterator<Integer> iterator() {
                Iterator<Integer> it = new Iterator<Integer>(){

                    private int nextValue = begin;
                    private final int max = end;

                    public boolean hasNext() {
                        return nextValue <= max;
                    }

                    public Integer next() {
                        if (!hasNext()) {
                            throw new NoSuchElementException();
                        }
                        return Integer.valueOf(nextValue++);
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
                return it;
            }
        };
    }

    public static void main(String[] args) {

         for (int i : panel1(1,5)) {
            System.out.println(i);
         }
    }
}