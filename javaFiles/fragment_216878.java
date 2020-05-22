Map<Long, Post> postByIdMap = (Map<Long, Post>) entityManager
.createQuery(
    "select p " +
    "from Post p ")
.unwrap(org.hibernate.query.Query.class)
.setResultTransformer(
    new ResultTransformer() {

        Map<Long, Post> result = new HashMap<>();

        @Override
        public Object transformTuple(Object[] tuple, String[] aliases) {
            Post post = (Post) tuple[0];
            result.put(
                post.getId(),
                post
            );
            return tuple;
        }

        @Override
        public List transformList(List collection) {
            return Collections.singletonList(result);
        }
    }
)
.getSingleResult();

assertEquals(
    "High-Performance Java Persistence eBook has been released!",
    postByIdMap.get(1L).getTitle()
);

assertEquals(
    "Hypersistence Optimizer has been released!",
    postByIdMap.get(5L).getTitle()
);