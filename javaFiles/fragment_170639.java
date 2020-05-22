Override
@Transactional
public void addStudentToClass(MyClass myClass, Student student) {
    myClass.getStudentList().add(student);
    classDao.update(myClass);
}