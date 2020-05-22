List<Person> persons = Arrays.asList(
                new Person(2,3,1,4),
                new Person(3,1,4,1)
            );
    // Print grid
    for (int activity = 1; activity <= 4; ++activity) {
        System.out.print(activity);
        for (Person p: persons) {
            System.out.print(" ");
            System.out.print(p.costOf(activity));
        }
        System.out.println();
    }