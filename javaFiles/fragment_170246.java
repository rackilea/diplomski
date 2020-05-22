class LevelItem
{
   private final Level level;
   public LevelItem(Level level) {this.level=level;}
   public String toString()
   {
     if(Level.WARNING.equals(level) return "Warning";
     if(Level.INFO.equals(level) return "Information";
...
     }
   }
}