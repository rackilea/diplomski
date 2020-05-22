@Test 
public void testCountPerson() {
    School school = School.getInstance();
    School spySchool = Mockito.spy(school);
    spySchool.countPerson(true);
    verify(spySchool).countIncludeTeacher();
}