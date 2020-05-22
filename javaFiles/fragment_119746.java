public class Main {
    // Holds the sorted names
    private static List<Name> names = new ArrayList<>();

    public static void main(String[] args) {
        // The method (in case something else than "sort" is desired)
        String method = args[0];

        // Check for valid method
        if(!method.equals("sort")) return;

        // The input names
        String[] input = Arrays.copyOfRange(args, 1, args.length);

        // Prepare list for sorting
        String firstName;
        String lastName;
        String[] completeName;

        for (String fullName : input) {
            completeName = Name.getName(fullName);
            firstName = completeName[0];
            lastName = completeName[1];
            names.add(new Name(firstName, lastName));
        }

        // Actually sort
        names.sort(new NameComparator());

        // Print
        names.forEach(System.out::println);
    }
}