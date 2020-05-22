//create the new HashSet
Set<Person> set = new HashSet<Person>();
//create your elements to be inserted
Person a= new Person("bob",45);
Person b=new Person("bob",41);
Person c= new Person("charlie",48);
//try to add "a". It will calculate hashCode from name field,
//which value is "bob"
set.add(a);
//try to add "b". It will calculate hashCode from name field,
//which value is "bob"
//since the index calculated from the hashCode of "bob" is
//already inserted, it will check if the element already exists
//Looking at Person#equals, which is based on name field only
//there is an element where the name field has a value of "bob"
//"b" won't be inserted
set.add(b);
//try to add "c". It will calculate hashCode from name field,
//which value is "charlie"
set.add(c);