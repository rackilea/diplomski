public static boolean nameRessemble(String initialName, String name){      
    String pattern = initialName.replaceAll( "(?i)e|è|é|ê|ë", "[eèéêëÉÈÊËE]" );
    pattern = pattern.replaceAll( "i|ï|î", "[iïîIÏÎ]" );
    pattern = pattern.replaceAll( "c|ç", "[cçCÇ]" );
    boolean match= name.matches("(?i).*" + pattern +".*");
    return match;

}