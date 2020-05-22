public void add(java.util.Map map, java.lang.Object o);
     0  aload_1 [map]
     1  invokeinterface java.util.Map.size() : int [16] [nargs: 1]
     6  istore_3 [index]
     7  aload_1 [map]
     8  iload_3 [index]
     9  invokestatic java.lang.Integer.valueOf(int) : java.lang.Integer [22]
    12  aload_2 [o]
    13  invokeinterface java.util.Map.put(java.lang.Object, java.lang.Object) : java.lang.Object [28] [nargs: 3]
    18  pop
    19  return
      Line numbers:
        [pc: 0, line: 8]
        [pc: 7, line: 9]
        [pc: 19, line: 10]
      Local variable table:
        [pc: 0, pc: 20] local: this index: 0 type: MapListTest
        [pc: 0, pc: 20] local: map index: 1 type: java.util.Map
        [pc: 0, pc: 20] local: o index: 2 type: java.lang.Object
        [pc: 7, pc: 20] local: index index: 3 type: int

  // Method descriptor #38 (Ljava/util/List;Ljava/lang/Object;)V
  // Stack: 2, Locals: 2
  public static void add(java.util.List list, java.lang.Object o);
    0  aload_0 [list]
    1  aload_1 [o]
    2  invokeinterface java.util.List.add(java.lang.Object) : boolean [39] [nargs: 2]
    7  pop
    8  return
      Line numbers:
        [pc: 0, line: 13]
        [pc: 8, line: 14]
      Local variable table:
        [pc: 0, pc: 9] local: list index: 0 type: java.util.List
        [pc: 0, pc: 9] local: o index: 1 type: java.lang.Object