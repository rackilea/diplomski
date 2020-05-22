List<Object> list = new ArrayList<>();
list.add(2);
list.add(4);
Foo foo = new Foo(TypeEnum.A(), JavaConversions.asScalaBuffer(list).toList());
System.out.println(foo.param1());
System.out.println(foo.sum());