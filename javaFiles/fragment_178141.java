import java.util.*;

class GenericDeclarationTest {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("");
        String s1 = list1.get(0);
        List<String> list2 = new ArrayList();
        list2.add("");
        String s2 = list2.get(0);
    }
}