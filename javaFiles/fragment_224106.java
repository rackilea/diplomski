public List<Job> getAllJobsForUser(String username) {
  List<Job> jobs = entityManager
    .createQuery("SELECT j FROM Job j JOIN User u WHERE u.name = :name")
    .setParameter("name", username)
    .setHint(QueryHints.BATCH, "j.history")
    .queryForList();
}