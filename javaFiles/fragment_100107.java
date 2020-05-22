public static void main(String[] args) {
    Map<Integer, Patient> patients = new HashMap<>();

    patients.put(0, new Patient("btest", 12));
    patients.put(1, new Patient("atest", 11));
    patients.put(2, new Patient("dtest", 10));
    patients.put(3, new Patient("ctest", 13));

    System.out.println("Ascending");
    patients
            .values()
            .stream()
            .sorted(Comparator.comparing(Patient::getAge))
            .forEach(System.out::println);

    System.out.println("Descending");
    patients
            .values()
            .stream()
            .sorted(Comparator.comparing(Patient::getAge).reversed())
            .forEach(System.out::println);
}