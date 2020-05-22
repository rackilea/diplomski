@javax.ws.rs.ApplicationPath("v1")
public class MyAppV1 extends java.ws.rs.Application {
    Set<Class<?>> getClasses() {
       return new java.util.HashSet<>(java.util.Arrays.asList(
           ClientService.class,
           OtherService.class));
    }
}