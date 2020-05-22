public static Predicate getPred() {
            return new @PredicateMeta(data = 0, name = "name", operator = "+")Predicate() {
                @Override
                public boolean test(Object o) {
                    return true;
                }
            };
        }