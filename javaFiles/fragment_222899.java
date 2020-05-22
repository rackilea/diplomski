class MyComponent extends JButton
{
    final int i; // matrix row
    final int j; // matrix col

    // constructor
    MyComponent(String text, int i, int j)
    {
        super(text);
        this.i = i;
        this.j = j;
    }

    ...
}