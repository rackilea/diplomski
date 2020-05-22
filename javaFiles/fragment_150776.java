static abstract class Animal{
    public abstract void speak();
}

static class Pig extends Animal{
    @Override public void speak(){ System.out.println("oink"); }
}

static class Goat extends Animal{
    @Override public void speak(){ System.out.println("baah"); }
}

static void converse(List<Animal> list){
    for(Animal a : list) System.out.println(a.speak());
}

public static void main(String[] args){
    List<Animal> l = new LinkedList<Animal>();
    l.add(new Pig());
    l.add(new Goat());
    converse(l);
}