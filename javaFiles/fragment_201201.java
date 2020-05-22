ObjectWithDoubleValue a1= new ObjectWithDoubleValue();
a1.a=3.0;

ObjectWithDoubleValue a2= new ObjectWithDoubleValue();
a2.a=3.0;
ObjectWithDoubleValue[] aa={a1,a2};
System.out.println(Arrays.stream(aa).mapToDouble(ObjectWithDoubleValue::getValue).sum());