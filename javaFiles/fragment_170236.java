String array1 []={"a","b","c","d","e","f"};
  String array2 [][] ={{"a","b","c","d"},{"d","e","f","g"}};

  List<String> array1AsList = Arrays.asList(array1);

  for (int i = 0; i < array2.length; i++) {
      List<String> array2rowAsList = Arrays.asList(array2[i]);

      if(array1AsList.containsAll(array2rowAsList)){
          System.out.println("row " + i + " is complete");
      }
  }