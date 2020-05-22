public class PutStr implements IO <Unit> {
  private String str;
  public PutStr (String s) {
      str = s;
  }
  public Unit run () {
      System.out.print(str);
      return Unit.unit;
  }
}

public final class Unit {
  private Unit () {}
  public static final Unit unit = new Unit ();
}

public class GetLine implements IO <String> {
    private GetLine () {}
    public static final GetLine getLine = new GetLine ();
    public String run () {
      // Replace the next line with whatever you actually use to
      // read a string.
      return "";
  }
}