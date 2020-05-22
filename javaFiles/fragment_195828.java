interface Driver extends SimpleBeanEditorDriver<List<Foo>, ListEditor<Foo, FooEditor>> {}
Driver driver = GWT.create(Driver.class);
FooListEditor fooListEditor = new FooListEditor();

/* snip */

driver.initialize(FooListEditor);
driver.edit(someListOfFoo);