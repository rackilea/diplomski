public class ShipSection extends Cell{
    @Override
    protected void drawNotStricken(){
        //draw section
    }

    @Override     
    protected void drawStricken(){
        //draw section in fire
    }

    @Override
    protected boolean isItHit(){
        return true
    }
}