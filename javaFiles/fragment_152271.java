String s = Switch.of(1,
        when(0, () -> "zero"),
        when(1, () -> "one"),
        when(2, () -> "two"))
        .orElse("not found");
System.out.println(s);