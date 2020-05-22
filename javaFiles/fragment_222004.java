public interface BoxCreator {
    public Box create(int id, List<Box> others);
}
public class Shed implements BoxCreator {
    @Override
    public ShedBox create(int id, List<Box> others) {
        ...
    }
}
public class CoolShed extends Shed {
    @Override
    public CoolBox create(int id, List<Box> others) {
        ...
    }
}