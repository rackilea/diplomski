class SpecialItemProcessor 
    implements 
       MusicBox.Visitor, 
       TypeWriter.Visitor, 
       SoccerBall.Visitor, 
       Item.Visitor
 {
    public void add(Item item)
    {
        item.accept(this);
    }
    @Override public void visitMusicBox(MusicBox item)
    {
        ...
    }
    @Override public void visitTypeWriter(TypeWriter item)
    {
        ...
    }
    @Override public void visitSoccerBall(SoccerBall item)
    {
        ...
    }
    @Override public void visit(Item item)
    {
        /* not sure what if anything I should do here */
    }
 }