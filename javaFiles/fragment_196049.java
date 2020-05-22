public @Rule CompilationRule rule = new CompilationRule();
private Elements elements;
private Types types;


@Before
public void setup() {
  elements = rule.getElements();
  types = rule.getTypes();
}

@Test void testStuff() {
  TypeElement typeElement = elements.getTypeElement("some.fully.qualified.ClassName");
  // do stuff.
}