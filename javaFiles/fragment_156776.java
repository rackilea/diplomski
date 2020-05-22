public abstract void displayProperties();

    @Override
    public int compareTo(Fruit otherFruit){
        return 0;
    }

}


public class Banana extends Fruit {
    private int seedCount;
    @Override
    public void displayProperties() {
        // TODO Auto-generated method stub
        System.out.println(seedCount);
    }

}

public class Grape extends Fruit{
    private String color;
    @Override
    public void displayProperties() {
        // TODO Auto-generated method stub
        System.out.println(color);
    }

}