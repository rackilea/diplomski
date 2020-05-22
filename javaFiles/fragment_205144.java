String result;
........
 if((s.hasNext(("get:"))||s.hasNext(("post:")) || s.hasNext(("put:")) || s.hasNext(("delete:"))))
                {
                    result = str;
                    System.out.println(str);
                }

.......
 System.out.println(result);