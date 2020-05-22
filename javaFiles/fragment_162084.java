final Map<Integer, Boolean> set = new HashMap<>(A.length);
    for (final int i : A) {
        set.put(i, set.containsKey(i)); // store number from array, set to true if there are multiple occurrences of 2 numbers
    }
    for (final int i : A) {
        final int mult = 225 / i;
        if ((mult * i) == 225) { // test that integral multiplication leads to 225
            final Boolean m = set.get(mult);
            if (m != null) { // we have both numbers in set, now we should filter double counting
                if ((i != mult) || ((i == mult) && m.booleanValue()))
                    return true;
            }

        }
    }
    return false;