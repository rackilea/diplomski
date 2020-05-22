public class R2D2 extends Casillas
{
    public R2D2 inicio(int x, int y)
    {
        // instead of this:
        //coordenadas.Posicion(x, y);

        // do:
        coordenadas = new Posicion(x, y);

        R2D2 art = new R2D2();
        art.Casillas('A', coordenadas);

        return art;
    }
}