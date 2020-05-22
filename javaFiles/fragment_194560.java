al.add(Str1); //al -> [String 1]
alal.add(al); //alal -> [ [String 1] ]

al.clear(); //al -> []   ,   alal -> [ [] ]
al.add(Str2); // al -> [String 2] , alal -> [ [String 2] ]
alal.add(Str3); //alal -> [ [String 2], String 3]

System.out.println(al);
System.out.println(alal);