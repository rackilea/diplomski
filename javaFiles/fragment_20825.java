public class Element{
    private int index;
    private double value;

    public Element(int i, double v)
    {
        index = i;
        value = v;
    }

    public int getIndex() { return index;}
    public double getValue() { return value;}
    public void setValue(double v) { value = v;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element)) return false;

        Element element = (Element) o;

        if (index != element.index) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return index;
    }
}