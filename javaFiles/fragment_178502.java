if (namesList.stream()
            .filter(x -> (x.equals("John") || x.equals(("Roger"))))
            .collect(Collectors.toSet())
            .size() == 2) {
        System.out.print("John & Roger");
    }

    if (namesList.stream()
            .filter(x -> (x.equals("Jane") || x.equals(("Smith"))))
            .collect(Collectors.toSet())
            .size() == 2) {
        System.out.print("Hane Smith");
    }