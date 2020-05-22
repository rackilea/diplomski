public class Estadisticas {
  private String c1, c2;
  private int nivel, salud, ataque, defensa, saludM1, ataqueM1;

  public void stats() {
    c1 = "Tu personaje";
    nivel = 1;
    salud = 50;
    ataque = 2;
    defensa = 1;

    c2 = "Primer monstruo - Rata rabiosa";
    saludM1 = 2;
    ataqueM1 = 1; 
  }

  //accessor method
  public String getc1() {
    return c1;
  }
}