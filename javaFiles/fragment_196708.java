public class Polynomial<T> implements Iterable<T>  {
    Map<Integer, T> polynomial;

    public Polynomial(){
        polynomial = new HashMap<Integer, T>();
    }
    public  Polynomial(int numberOfMembers){
        polynomial = new HashMap<Integer, T>(numberOfMembers);
    }
    public void addElm(int power, T coefficient){
        if (power < 0) {
            throw new RuntimeException("ERROR: The power must be an absolute number");
        }
        polynomial.put(power,coefficient);
    }
    @Override
    public Iterator<T> iterator() {
        return polynomial.values().iterator();
    }

}