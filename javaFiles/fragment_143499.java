import java.util.*;

public class StackQ2 {

    static class IntContainer {
        public IntContainer(int a, int b) {
            this.a = a;
            this.b = b;
        }
        int a;
        int b;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass())
                return false;

            IntContainer that = (IntContainer) o;

            if (a != that.a) return false;
            return b == that.b;

        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            return result;
        }

        @Override
        public String toString() {
            return "{" + a + "," + b + "}";
        }
    }
    public static void main(String[] args) {

        List<IntContainer> array = Arrays.asList(
                new IntContainer(0, 1),
                new IntContainer(0, 2),
                new IntContainer(1, 1),
                new IntContainer(3, 5),
                new IntContainer(1, 1),
                new IntContainer(2, 2)
        );
        List<IntContainer>  norepetition = new ArrayList<>();
        Set<IntContainer> withrepetition = new HashSet<>();
        for (IntContainer element : array) {
            if (Collections.frequency(array, element) > 1) {
                withrepetition.add(element);
            } else {
                norepetition.add(element);
            }
        }

        System.out.println("NoRep: " +Arrays.toString(norepetition.toArray()));
        System.out.println("Rep: " +Arrays.toString(withrepetition.toArray()));

    }