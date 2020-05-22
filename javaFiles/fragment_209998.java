@Transactional
public User findById(Long id) {
    return new SQLQuery(getConnection(), getConfiguration())
      .from(user)
      .where(user.id.eq(id))
      .singleResult(user);
}