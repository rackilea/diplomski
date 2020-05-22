hibernateTemplate.execute(new HibernateCallback<List>() {

    public String doInHibernate(Session s)
            throws HibernateException, SQLException {
        SQLQuery sql=s.createSQLQuery("select course_id from student_course where student_id=?");
            sql.setParameter(0, adventureId);
        sql.addScalar(studentID);
        return sql.list();
    }
});