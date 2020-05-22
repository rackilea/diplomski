Collections.sort(contacts, (Contact c1, Contact c2) -> {
        int firstNameComparisonResult = c1.getFirstName().compareTo(c2.getFirstName());
        if (firstNameComparisonResult != 0) {
            return firstNameComparisonResult;
        } else {
            return c1.getLastName().compareTo(c2.getLastName());
        }
    });