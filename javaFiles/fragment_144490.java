import java.lang.annotation.Annotation;

@RemoteTcpAccess(port = 322)
public class AnnotationTest {

    /**
     * @param args
     * @throws NoSuchFieldException
     * @throws SecurityException
     */
    public static void main(String[] args) throws SecurityException,
            NoSuchFieldException {
        Annotation anno = AnnotationTest.class
                .getAnnotation(RemoteTcpAccess.class);
        if (anno instanceof RemoteTcpAccess) {
            RemoteTcpAccess rta = (RemoteTcpAccess) anno;
            System.out.println(rta.port());
        }
    }
}