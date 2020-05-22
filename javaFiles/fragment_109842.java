public interface RepositorySystem {

    public void doStuff() // add whatever methods you need here

    public DetailWrapper getDetails() // maybe you need more wrapper interfaces and matching implementations, when you aren't dealing with just one class.
}

public class RepositorySystemAdapterPreMavenXXX implements RepositorySystem {
    org.sonatype.aether.RepositorySystem delegate = new org.sonatype.aether.RepositorySystem();
    public void doStuff(){
        delegate.doStuff();
    }

    // ...
}

public class RepositorySystemAdapterPostMavenXXX implements RepositorySystem {
    org.eclipse.aether.RepositorySystem delegate = new org.eclipse.aether.RepositorySystem();
    public void doStuff(){
        delegate.doStuff();
    }

    // ...
}

public class RepositorySystemFactory{
    public static RepositorySystem repositorySystem(){
        try {
            return new RepositorySystemAdapterPostMavenXXX(); // you might have to use reflection to do this ... not completely sure;
        } catch(Error error) { // find out what kind of error/exception you get and catch exactly that
            return  new RepositorySystemAdapterPreMavenXXX();
        }
    }
}