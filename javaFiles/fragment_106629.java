@Test
public void testUpdateOfEnum() {
    MyEntity e = new MyEntity();
    e.setExamType(ExamType.A);

    em.persist(e);
    em.flush();

    assertNotNull(e.getId());
    assertEquals(ExamType.A, e.getExamType());

    e.setExamType(ExamType.B);
    em.merge(e);
    em.flush();

    em.refresh(e); // to ensure we assert against value read from the db
    assertEquals(ExamType.B, e.getExamType());
}