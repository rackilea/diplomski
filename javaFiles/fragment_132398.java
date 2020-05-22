@Transactional
public void insertWithTeacherId(Student student, long teacher_id) {
    entityManager.createNativeQuery("INSERT INTO student (id, teacher_id) VALUES (?,?)")
      .setParameter(1, student.getId())
      .setParameter(2, teacher_id)
      .executeUpdate();
}