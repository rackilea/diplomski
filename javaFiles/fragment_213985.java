List resultWithAliasedBean = s.createQuery(
  "select e.student.name as studentName," +
  "       e.course.description as courseDescription" +
  "from   Enrolment as e")
  .setResultTransformer( Transformers.aliasToBean(StudentDTO.class))
  .list();

StudentDTO dto = (StudentDTO) resultWithAliasedBean.get(0);