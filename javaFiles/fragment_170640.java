Override
@Transactional
public void addStudentToClass(MyClass myClass, Student student) {
    MyClass attachedMyClass = classDao.merge(myClass);
    attachedMyClass.getStudentList().add(student);
}