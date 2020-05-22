StringBuilder a = new StringBuilder("did");
    StringBuilder b = new StringBuilder(a);

    if (b.toString().equals(a.reverse().toString())) {
        System.out.println("true");
    } else {
        System.out.println("false");
    }