public void coursename() {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();
    Query query = session.createQuery("select a.courseName,a.courseId  from Semester e inner join e.course as a");
    for (Iterator it = query.iterate(); it.hasNext();) {
        Object row[] = (Object[]) it.next();
        combocourse.addItem(new CourseItem((String)row[0], (String)row[1]));
    }
    session.close();
}

private void combocourseActionPerformed(java.awt.event.ActionEvent evt) {


    JComboBox combocourse = (JComboBox) evt.getSource();
    CourseItem item = (CourseItem)combocourse.getSelectedItem();
    System.out.println("id" + item.getCourseId());

}