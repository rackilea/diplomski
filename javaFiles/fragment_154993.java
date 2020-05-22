public interface GameObejct {

        int getProperty1();
        int getProperty2();
    }

 public class Person implements GameObejct {
    @Override
    public int getProperty1() {
        return 0;
    }

    @Override
    public int getProperty2() {
        return 0;
    }
}

public class Monster implements GameObejct{
    @Override
    public int getProperty1() {
        return 0;
    }

    @Override
    public int getProperty2() {
        return 0;
    }
}