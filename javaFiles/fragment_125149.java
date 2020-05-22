public enum Lookup{
     ADDRESS("$1".address),
     NAME("$1".name);
     private final String pattern;
     private Lookup lookup(String pattern){
         this.pattern=pattern;
     }
     public final String lookupProperty(String input){
         return System.getProperties().get(
             this.pattern.replace("$1",input)
         );
     }
 }