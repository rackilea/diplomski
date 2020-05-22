Base b = create("myArgument");
if(b instanceof SomeDerived){
  SomeDerived d = (SomeDerived) b;
  // use d
} else if(b instanceof OtherDerived){
  // you get the idea
}