package collection.delta;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import collection.delta.model.A;
import collection.delta.model.B;

public class App {
    public static void main( String[] args ) {

        List<A> originalA = new ArrayList<A>();
        List<A> newA = new ArrayList<A>();

        List<B> bListOriginalA1 = new ArrayList<B>();
        bListOriginalA1.add(new B("originalA1_B1"));
        bListOriginalA1.add(new B("originalA1_B2"));
        bListOriginalA1.add(new B("originalA1_B3"));
        bListOriginalA1.add(new B("originalA1_B4"));

        A originalA1 = new A("originalA1", bListOriginalA1);

        List<B> bListOriginalA2 = new ArrayList<B>();
        bListOriginalA2.add(new B("originalA2_B1"));
        bListOriginalA2.add(new B("originalA2_B2"));
        bListOriginalA2.add(new B("originalA2_B3"));
        bListOriginalA2.add(new B("originalA2_B4"));

        A originalA2 = new A("originalA2", bListOriginalA2);

        List<B> bListOriginalA3 = new ArrayList<B>();
        bListOriginalA3.add(new B("originalA3_B1"));
        bListOriginalA3.add(new B("originalA3_B2"));
        bListOriginalA3.add(new B("originalA3_B3"));
        bListOriginalA3.add(new B("originalA3_B4"));

        A originalA3 = new A("originalA3", bListOriginalA3);

        originalA.add(originalA1);
        originalA.add(originalA2);
        originalA.add(originalA3);


        List<B> bListNewA1 = new ArrayList<B>();
        bListNewA1.add(new B("originalA1_B1"));
        bListNewA1.add(new B("originalA1_B2"));
        bListNewA1.add(new B("originalA1_B3"));
        bListNewA1.add(new B("originalA1_B4"));

        A newA1 = new A("originalA1", bListNewA1);

        List<B> bListNewA2 = new ArrayList<B>();
        bListNewA2.add(new B("originalA2_B1"));
        bListNewA2.add(new B("originalA2_B3"));
        bListNewA2.add(new B("originalA2_B4"));
        bListNewA2.add(new B("originalA2_B2"));

        A newA2 = new A("originalA2", bListNewA2);

        List<B> bListNewA3 = new ArrayList<B>();
        bListNewA3.add(new B("originalA3_B1"));
        bListNewA3.add(new B("originalA3_B2"));
        bListNewA3.add(new B("originalA3_B5"));
        bListNewA3.add(new B("originalA3_B4"));

        A newA3 = new A("originalA3", bListNewA3);

        List<B> bListNewA4 = new ArrayList<B>();
        bListNewA4.add(new B("A4_B1"));
        bListNewA4.add(new B("A4_B2"));
        bListNewA4.add(new B("A4_B3"));
        bListNewA4.add(new B("A4_B4"));

        A newA4 = new A("originalA4", bListNewA4);

        newA.add(newA1);
        newA.add(newA2);
        newA.add(newA3);
        newA.add(newA4);

        List<A> result = newA.stream()
                .filter(not(new HashSet<A>(originalA)::contains))
                .collect(Collectors.toList());

        A tempA = null;
        B tempB = null;
        List<B> bList = null;
        for (A a : result) {
            if (!containsName(originalA, a.getaName())) {
                originalA.add(a);
            } else {
                tempA = getAIfPresent(originalA, a.getaName());

                if (tempA != null) {

                    bList = a.getbList().stream()
                            .filter(not(new HashSet<B>(tempA.getbList())::contains))
                            .collect(Collectors.toList());

                    if (bList != null) {
                        tempA.getbList().addAll(bList);
                    }
                }
            }
        }

        System.out.println("");
    }

    public static <T> Predicate<T> not(Predicate<T> predicate) {
        return predicate.negate();
    }

    public static boolean containsName(final List<A> list, final String name){
        return list.stream().map(A::getaName).filter(name::equals).findFirst().isPresent();
    }

    public static A getAIfPresent(final List<A> list, final String name) {
        return list.stream().filter(x -> x.getaName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

}