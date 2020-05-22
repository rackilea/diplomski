public int compare(Integer i1, Integer i2) {
        Integer r1 = hammingDistanceToReference(i1);
        Integer r2 = hammingDistanceToReference(i2);

        if (!r1.equals(r2))
            return r1.compareTo(r2);

        return i1.compareTo(i2);
    }