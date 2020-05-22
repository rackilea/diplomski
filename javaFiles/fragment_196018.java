SomeObject o = new SomeObject();

list0.add(o);
list1.add(o);
list2.add(o);

o.setSomeValue(true);

// all lists will "see" the changes

list0.get(0).equals(o); // assuming list0 only contains o -> this is true