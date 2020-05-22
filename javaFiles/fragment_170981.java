public Foo acquireFoo(int id) {
  Foo result = null;
  if (id > 50) {
    result = fooService.read(id);
  } else {
    result = new Foo(id);
  }
  assert result != null;

  return result;
}