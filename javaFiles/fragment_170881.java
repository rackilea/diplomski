@Test
public void shouldMapAToY() {
    A a = new A();
    a.setA("a variable");
    final B b = new B();
    b.setB("stuff from class b");
    a.setB(b);

    Y y = AMapper.INSTANCE.aToY(a);
    assertThat(y).isNotNull();
    assertThat(y.getB()).isEqualTo(b.getB());
}