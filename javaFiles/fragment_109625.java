// pseudo code
String[] safeList(String[] list) { if list.length == 0 return {''} else return list; }

// carthesian product with a twist
static void safeProductWithATwist(
    String[] listA, String[] listB, String[] listC) {
    for(String a: safeList(listA)) 
      for(String b: safeList(listB)) 
        for(String c: safeList(listC)) 
          foo(a, b, c);
}