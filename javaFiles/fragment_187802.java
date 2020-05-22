Comparator<MyClass> myRules = Comparator.comparing(t -> {
    if (t.aString.equals("Hi")) {
        return 0;
    }
    if (t.aString.startsWith(" ")) {
        return 1;
    }
    else {
        return 2;
    }
});