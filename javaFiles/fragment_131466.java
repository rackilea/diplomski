public int compare(Integer a, Integer b) {
        if (base.get(a).charAt(0) == base.get(b).charAt(0))
            return 0;

        else if (base.get(a).charAt(0) > base.get(b).charAt(0))
            return 1;

        else
            return -1;
    }