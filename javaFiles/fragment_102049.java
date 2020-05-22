switch(classId): {
  case 1:
     myObj = new DerivedClass1();
     break;
  case 2:
     myObj = new DerivedClass2();
     break;
  case 3:
     myObj = new DerivedClass3();
     break
  default:
     throw RuntimeException ("Id not recognized);
}
Do something with object;