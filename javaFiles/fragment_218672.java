System.out.println(dynamicList.getList().getInfo());
(dynamicList)  "C" -> "A" -> null
               ^^^                  prints "C"

System.out.println(dynamicList.getList().getNext().getInfo());
(dynamicList)  "C" -> "A" -> null
                      ^^^           prints "A"

System.out.println(dynamicList.getList().getNext().getNext().getInfo());
(dynamicList)  "C" -> "A" -> null
                             ^^^    null has no info to get