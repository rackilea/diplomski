class PrintHeartzzz{

    public static void main(String[] args){
      StringBuilder sb =new StringBuilder();
      int n=8;

      prepareLine("  _  _ ",sb,n);
      prepareLine(" ( \\/ )",sb,n);
      prepareLine("  \\  / ",sb,n);
      prepareLine("   \\/  ",sb,n);

      System.out.println(sb);

    }

    private static void prepareLine(String patternToDraw,StringBuilder sb,int nb){
      for(int i=0;i<nb;i++){
        sb.append(patternToDraw);
      }
        sb.append("\n");
    }

}