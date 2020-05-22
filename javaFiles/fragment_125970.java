public class Ponto2D 
{
    private int x; //2d plane shouldn't use floating coordinates.
    private int y;

    Ponto2D() { }; //ctor does nothing.

    public Ponto2D(int x, int y)
    {
       this();
       this.x = x;
       this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
}

public class Reta 
{
    private Ponto2D inicio;
    private Ponto2D fim;
    private int cor;

    Reta()
    {
       fin = new Ponta2D(); //might cause an error because it's not public
       inicio = new Ponta2D(-1, -1); //this should be ok 
    }

    public Reta(Ponto2D p1, Ponto2D p2)
    {