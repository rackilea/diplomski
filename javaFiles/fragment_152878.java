public interface Implementation {

}

public class ImplementationLookerUpper {

    Classloader v1 = new MyClassloader(version1);
    Classloader v2 = new MyClassloader(version2);


    public Implementation implementationUsingVersion(Version someversion) {

             Classloader classloader = pickCorrectClassLoaderForVersion(someVersion);

            return (Implementation) classloader.loadClass(RealImplementation.class.getName()).newInstance();

    }
}