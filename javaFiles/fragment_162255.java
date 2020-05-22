public enum Baz{
  yin("yang"),    
  yang("yin"),
  good("evil"),   
  evil("good");

  private String opposite;

  Baz(String opposite){
    this.opposite = opposite;
  }

  public Baz getOpposite(){
     return Baz.valueOf(opposite);
  }
}