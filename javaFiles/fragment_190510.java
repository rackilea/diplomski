bindings.bind(qRate.rateFlag).first(
            (path, value) -> {
                Expression<Integer> zeroValue = Expressions.asNumber(0);
                NumberTemplate<Integer> numberTemplate = Expressions.numberTemplate(Integer.class, "function('bitand', {0}, {1})", path, value);
                return numberTemplate.gt(0);
            });