GetSet002 p1 = new GetSet002("Conan", 14);
//result: GetSet002 = ("Conan" , 14)
GetSet002 p2 = new GetSet002("Natsu", 18);
//result: GetSet = ("Natsu" , 18);

if(p1.getAge() == p2.getAge())
//is semantically equal to:
if(GetSet002.age == GetSet002.age)
//public accessiblity is only implied for demonstration