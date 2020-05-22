public class BirdButton extends EventButton
{
    public BirdButton(String n, int x, int y, Animals a, JTextField field) {
        super(n);
        setLabel(n);
        setBounds(50,10,x,y);
        setField(field);
        a.add(this);
    }

    public BirdButton(String n, int x, int y, Animals a) {
        this(n, x, y, a, null);
    }
}