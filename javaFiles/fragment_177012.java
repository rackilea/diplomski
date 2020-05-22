Mon m1 = new Mon(); m1.setStart("A"); m1.setEnd("a;b");
Mon m2 = new Mon(); m2.setStart("A"); m2.setEnd("b");
Mon m3 = new Mon(); m3.setStart("C"); m3.setEnd("c");

List<Mon> list = new ArrayList();
list.add(m1);list.add(m2);list.add(m3);

Function<Mon, String> compositeKey = mon -> mon.getStart()+mon.getEnd();

Map<String, List<Mon>> resultMap = list.stream().collect(Collectors.groupingBy(compositeKey,Collectors.toList()));