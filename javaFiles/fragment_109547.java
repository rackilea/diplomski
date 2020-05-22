int[][][] ary = {{{0},{1}}};

        Class cls = ary.getClass();

        boolean isAry = cls.isArray();
        String clsName = cls.getName();

        System.out.println("is array=" + isAry);
        System.out.println("name=" + clsName);

        int nrDims = 1 + clsName.lastIndexOf('[');

        System.out.println("nrDims=" + nrDims);

        Object orly = ary;

        for (int n = 0; n < nrDims; n++) {

            int len = Array.getLength(orly);

            System.out.println("dim[" + n + "]=" + len);

            if (0 < len) {
                orly = Array.get(orly, 0);
            }
        }