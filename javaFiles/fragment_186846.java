public class Sort {

private static void doIterate(List<Name> names, List<Name> results) {
        Name firstName = new Name("zzz", "zzz");
        for (Name name : names) {
            if (name.getFirstName().compareTo(firstName.getFirstName()) < 0
                    || name.getFirstName().equals(firstName.getFirstName())
                            && name.getSurName().compareTo(firstName.getSurName()) < 0) {
                firstName = new Name(name.getFirstName(), name.getSurName());
            }
        }

        results.add(firstName);

        names.remove(firstName);
}

public static ArrayList<Name> sort1(ArrayList<Name> names) {

    ArrayList<Name> results;

    results = new ArrayList<Name>();

    int count = names.size();
    doIterate(names, results);
    count--;
    while (count > 0) {
      doIterate(names, results);
      count--;
    }

    return results;
}}}