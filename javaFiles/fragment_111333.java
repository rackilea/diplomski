public class LowerBody extends ContainerPart {

    public LowerBody(Legs[] legs, Feet[] feet, String name, String color, int xCoord, int yCoord){
         super(name, color,xCoord, yCoord, legs);
         ........
         .......
    }

    public LowerBody(Legs leg, Feet feet, String name, String color, int xCoord, int yCoord){
        super(name, color,xCoord, yCoord, new BodyPart[]{leg, feet});
    }
}