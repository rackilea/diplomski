public class TestHashSetUniqueness {
public static void main(String[] args) {
    HashSet<String> hashSet = new HashSet<String>();
    String oneSpace = " ";
    String twoSpaces = "  ";

    hashSet.add(oneSpace);
    hashSet.add(twoSpaces);

    // Here HashSet size is 2 as it is treating string objects oneSpace
    // and twoSpaces as two different strings.
    System.out.println("HashSet size without trim() : "+hashSet.size());

    hashSet.clear();
    hashSet.add(oneSpace.trim());
    hashSet.add(twoSpaces.trim());

    // As we are trimming(removing the excess spaces) spaces in the strings
    // causing our HashSet to have only one element there by avoiding duplicates
    System.out.println("HashSet size with trim() : "+hashSet.size());
}