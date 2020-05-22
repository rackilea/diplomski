List<Class2> list2WithConstructor = list1.stream().map(Class2::new).collect(Collectors.toList());
//change this.datas=... in Class2 constructor to:
this.datas = c.getDatas().stream().map(Class4::new).collect(Collectors.toSet());
//or to (depending of your use case):
this.datas = new HashSet<Class3>(c.getDatas()).stream().map(Class4::new).collect(Collectors.toSet());
//then you will feel the real constructor magic ;P