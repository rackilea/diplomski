public class Sudoku {

Integer values[] = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
List<Integer> list = new ArrayList<Integer>(Arrays.asList(values));

public boolean getFrontier(int value) {
    if (list.contains(value)) {
        list.remove(list.indexOf(value));
        return true;
    }
    return false;
}

public static void main(String[] args) {
    Sudoku su = new Sudoku();
    System.out.println(su.getFrontier(2));
    System.out.println(su.getFrontier(2));

    System.out.println(su.getFrontier(3));
    System.out.println(su.getFrontier(3));

    System.out.println(su.getFrontier(2));
} }