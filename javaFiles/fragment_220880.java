/**
 * ... Provides properties x, y,z; with defaults 50, 100, 150
 */
public class Foo {
  public final int BAR_DEFAULT = 50; 
  private int bar = BAR_DEFAULT;

  public void setBar(int newBar) { bar = newBar; }