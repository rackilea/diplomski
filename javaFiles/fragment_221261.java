public class MyTest {
  @Test
  public void speakTest() {
    Person p = new Person();
    Speaker speaker = mock(Speaker.class);
    p.speaker = speaker;

    AgeDAO dao = mock(AgeDAO.class);
    p.dao = dao;

    List<Jon> list = createJonList();
    List<Integer> ages = createAgesList();
    ages.add(5);  // Make the list of ages non-empty
    when(dao.getAge(anyList())).thenReturn(ages);
    p.checkSpeak(list);

    verify(p.speaker).speak(anyList());

  }

  private List<Integer> createAgesList() {
    return new ArrayList<Integer>();
  }

  private List<Jon> createJonList() {
    return new ArrayList<Jon>();
  }
}

class Person {
  AgeDAO dao;
  Speaker speaker;

  public void checkSpeak(List<Jon> list) {
    List<Integer> ages = dao.getAge(list);

    if (ages != null && !ages.isEmpty()) {
      speaker.speak(list);
    }
  }
}