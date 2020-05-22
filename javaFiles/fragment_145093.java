// For the testing purposes, package-visible final fields are perfect
// Gson can deal with final fields too
final class MyEntity {

    final int id = Integer.valueOf(0); // not letting javac to inline 0 since it's primitive
    final String name = null;

    @Override
    public String toString() {
        return id + "=>" + name;
    }

}