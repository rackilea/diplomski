public abstract class BodyPart {
  private String name;
  private String color;
      ......
      ......
}


public class DrawablePart extends BodyPart {

    public DrawablePart(){
        super();
    }
}

public class ContainerPart extends BodyPart {

    public ContainerPart(String name, String color, int xCoord, int yCoord, BodyPart[] yourParts){
        super(......);
        ...........
     }
}

public class Legs extends DrawablePart {

    public Legs(){
        super();
    }
}