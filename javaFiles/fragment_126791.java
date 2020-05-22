public static GeneralProduct<TypeA> createProduct(
            int type, UsedByProductThing<TypeA> in) {
        switch (type) {
            case 1:
                return new ProductA(in);
            default:
                throw new IllegalArgumentException("type unkown.");
        }
    }