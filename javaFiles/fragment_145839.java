public class Methodcall{
                       ArrayList <Object> al =  new ArrayList<Object>();
                        al.add(new Cat());
                        al.add(new Dog());
                        for(Object a:al)
                           {
                               class ax = a.getClass();
                               Method[] methods=ax.getdeclaredMethods();
                               for(Method m:methods)
                                 {
                                    System.out.println(method.getName);
                                  }
                            }
                 }
                }