import lombok.*;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MappingWithLambdas {
    private static Function<Class1,Class2> c1To2WithMapping = c1 -> {
        Function<Class3,Class4> c3to4 = c3 -> {
            Class4 c4 = new Class4();
            c4.setX(c3.getX());
            c4.setY(c3.getY());
            return c4;
        };
        Function<List<Class3>, Set<Class4>> listToSet = l -> l.stream().map(c3to4).collect(Collectors.toSet());
        Class2 c2 = new Class2();
        c2.setX(c1.getX());
        c2.setY(c1.getY());
        c2.setDatas(listToSet.apply(c1.getDatas()));
        return c2;
    };
    public static void main(String[] args) {
        Class1 c1 = new Class1();
        c1.setX("X"); c1.setY("Y");
        c1.setDatas(List.of(new Class3("x", "y"), new Class3("x", "y"), new Class3("x", "y")));
        System.out.println(c1);
        System.out.println("Using mapping function: ");
        System.out.println(c1To2WithMapping.apply(c1));
        Function<Class1,Class2> c1to2WithNew = Class2::new;
        System.out.println("Using Class2 constructor: ");
        System.out.println(c1to2WithNew.apply(c1));
        System.out.println("Simply with constructor: ");
        System.out.println(new Class2(c1));
    }
}
@Data
class Class1 {
    private String x;
    private String y;
    private List<Class3> datas;
}
@Data
class Class2 {
    private String x;
    private String y;
    private Set<Class4> datas;
    private Function<List<Class3>, Set<Class4>> listToSetWithNew = l -> l.stream().map(Class4::new).collect(Collectors.toSet());
    Class2() {}
    Class2(Class1 c) {
        this.x = c.getX();
        this.y = c.getY();
        this.datas = listToSetWithNew.apply(c.getDatas());
//List<Class3>->List<Class4>->Set<Class4>
//        this.datas = c.getDatas().stream().map(Class4::new).collect(Collectors.toSet());
//List<Class3>->Set<Class3>->Set<Class4>
//        this.datas = new HashSet<>(c.getDatas()).stream().map(Class4::new).collect(Collectors.toSet());
    }
}
@Data
class Class3 {
    private String x;
    private String y;
    Class3(String x, String y) {
        this.x = x;
        this.y = y;
    }
}
@Data
class Class4 {
    private String x;
    private String y;
    Class4() {}
    Class4(Class3 c) {
        this.x = c.getX();
        this.y = c.getY();
    }
}