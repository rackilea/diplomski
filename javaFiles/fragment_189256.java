Map<String, String> map = 
    StreamEx.of("a", "b", "err1", "c", "d", "err2", "e", "f", "g", "h", "err3", "i", "j")
            .pairMap((s1, s2) -> s1.startsWith("err") ? new String[] { s1, s2 } : null)
            .nonNull()
            .toMap(a -> a[0], a -> a[1]);

System.out.println(map);