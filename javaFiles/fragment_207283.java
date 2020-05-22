int somearray[] = new int[] { 1, 5, 6, 7 };

    HashMap<String, Integer> map = IntStream.range(0, 4).collect(
            HashMap::new,
            (result, t) -> result.put("test" + t, somearray[t]),
            (left, right) -> left.putAll(right));