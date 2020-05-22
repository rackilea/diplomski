public interface ToyInterface {
    public void play();
}

public class Toy implements ToyInterface {
    @Override
    public void play() {
        System.out.println("Play toy");
    }
}

public interface BoxInterface {
    public void open();
}

public class Box implements BoxInterface {
    @Override
    public void open() {
        System.out.println("open box");
    }
}

public class Container implements ToyInterface, BoxInterface {
    private BoxInterface box;
    private ToyInterface toy;

    public Container() {
        box = new Box();
        toy = new Toy();
    }

    public BoxInterface getBox() {
        return box;
    }

    public ToyInterface getToy() {
        return toy;
    }

    @Override
    public void play() {
        System.out.println("play container");
        this.toy.play();
    }

    @Override
    public void open() {
        System.out.println("open container");
        this.box.open();
    }
}