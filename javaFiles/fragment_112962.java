Set<Integer> setA= new HashSet<Integer>();
Set<Integer> setB= new HashSet<Integer>();

//add stuff to setA and setB by add() method

Set<Integer> uniqueToA=new HashSet<Integer>(setA);
Set<Integer> uniqueToB=new HashSet<Integer>(setB);
Set<Integer> shared=new HashSet<Integer>();
shared.addAll(setA);
shared.addAll(setB);

uniqueToA.removeAll(setB);
uniqueToB.removeAll(setA);

shared.removeAll(uniqueToA);
shared.removeAll(uniqueToB);

System.out.println(uniqueToA);  //unique to A
System.out.println(uniqueToB); //unique To B
System.out.println(shared);  //shared