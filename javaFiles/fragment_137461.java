scala> (array.zipWithIndex ++ array.zipWithIndex).foreach{
     |   case (x, i) => println(s"$i: $x")
     | }
0: a
1: b
2: c
0: a
1: b
2: c

scala> (array ++ array).zipWithIndex.foreach{
     |   case (x, i) => println(s"$i: $x")
     | }
0: a
1: b
2: c
3: a
4: b
5: c