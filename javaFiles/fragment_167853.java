public class Swimmers extends SwimmersPrototype{
    List<Swimmer> swimmers;
    SortStrategy sortStrategy;

    public Swimmers() {
        swimmers = new ArrayList();
    }

    public List<Swimmer> sort() {
        return sortStrategy.sort(swimmers);
    }

    @Override
    public SwimmersPrototype clone() throws CloneNotSupportedException{
        SwimmersPrototype swp = (Swimmers)super.clone();
        return swp;
    }
}