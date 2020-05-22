String s = "He ordered a pizza with anchovies. Unfortunately, it wasn't the thing he wanted. Besides, pizza with mushroom, pepperoni and anchovies is much better than the normal pizza with anchovies.";
s = s.replaceAll("(?i)pizza with [a-zA-Z,\\s]*?anchovies", "$0 on a thin crust");
System.out.println(s);
// => He ordered a pizza with anchovies on a thin crust. Unfortunately, it wasn't the thing 
//    he wanted. Besides, pizza with mushroom, pepperoni and anchovies on a thin crust is 
//    much better than the normal pizza with anchovies on a thin crust.