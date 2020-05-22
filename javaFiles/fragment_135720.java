Specification<Fts> spec = new Specification<Fts>() {
        @Override
        public Predicate toPredicate(Root<Fts> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
            JpaCriteriaBuilder cb = (JpaCriteriaBuilder) builder;
            List<String> args = new ArrayList();
            args.add("FTS query");

            javax.persistence.criteria.Expression<Boolean> expr = cb.fromExpression(
              cb.toExpression(
                cb.function("", Boolean.class, cb.fromExpression(((RootImpl) root).getCurrentNode().getField("fts")))
              )
              .sql("? @@ to_tsquery(?)", args)
            );
            // getField() allows to reference column not mapped to Entity

            query.where(expr);

            return null; // or return cb.isTrue(expr); and then not need to set query.where()
        }
    };