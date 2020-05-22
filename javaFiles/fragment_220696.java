try {
    try {

        throw new NullPointerException();

    } catch (NullPointerException e) {
        System.out.println("reached once");

        throw e;
    }
} catch (SomeOtherException ex) {}