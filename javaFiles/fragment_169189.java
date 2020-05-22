interface Item { 
   public void accept(Visitor visitor);
   ... 

   public interface Visitor {
      public void visit(Item item);
   }
}


class MusicBox implements Item { 
   public interface Visitor extends Item.Visitor {
      public void visitMusicBox(MusicBox item);
   }
   ... 
   @Override public accept(Item.Visitor visitor)
   {
      if (visitor instanceof MusicBox.Visitor)
      {
          ((MusicBox.Visitor)visitor).visitMusicBox(this);
      }
   }
}

class TypeWriter implements Item { 
   public interface Visitor extends Item.Visitor {
      public void visitTypeWriter(TypeWriter item);
   }
   ... 
   @Override public accept(Item.Visitor visitor)
   {
      if (visitor instanceof TypeWriter.Visitor)
      {
          ((TypeWriter.Visitor)visitor).visitTypeWriter(this);
      }
   }
}

class SoccerBall implements Item { 
   public interface Visitor extends Item.Visitorr {
      public void visitSoccerBall(SoccerBall item);
   }
   ... 
   @Override public accept(Item.Visitor visitor)
   {
      if (visitor instanceof SoccerBall.Visitor)
      {
          ((SoccerBall.Visitor)visitor).visitSoccerBall(this);
      }
   }
}