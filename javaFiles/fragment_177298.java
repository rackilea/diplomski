import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyAspect {
    private Child child;

    public MyAspect() {
        child = new Child("Scarlett");
        System.out.println("Aspect child is named " + child.getName());
        child.setName("Cristina");
        System.out.println("Aspect child is now named " + child.getName());
    }

    @Around(
        "(execution(public * Child.*(..)) || execution(public Child.new(..)))" +
        "&& !cflow(initialization(MyAspect.new()))"
    )
    public Object wrap(ProceedingJoinPoint point) throws Throwable {
        System.out.println(point.getStaticPart());
        return point.proceed();
    }
}