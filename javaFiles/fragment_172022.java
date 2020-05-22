abstract class Syncable {

    boolean toBeSynced;
    boolean toBeAdded;
    boolean toBeDeleted;

    abstract void sync();
    abstract void add();
    abstract void delete();
}