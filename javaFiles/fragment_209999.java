@Transactional
public User findById(Long id) {
    Path<Object> userPath = new PathImpl<Object>(Object.class, "user");
    NumberPath<Long> idPath = Expressions.numberPath(Long.class, userPath, "id");
    StringPath usernamePath = Expressions.stringPath(userPath, "username");
    Tuple tuple = new SQLQuery(getConnection(), getConfiguration())
      .from(userPath)
      .where(idPath.eq(id))
      .singleResult(idPath, usernamePath);
    return new User(tuple.get(idPath), tuple.get(usernamePath));
}