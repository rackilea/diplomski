public interface IMedia extends Nameable {
    // other stuff
    boolean sameCorporation(IMedia that);
}

public abstract class AbstractMedia implements IMedia {

    public abstract String getName();

    public boolean sameCorporation(IMedia that) {
        return that != null && Objects.equals(this.getName(), that.getName()); 
    }
}