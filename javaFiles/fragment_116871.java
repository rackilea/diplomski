Set<String> results1 = new HashSet<String>(allWords);
     results1.removeAll(list1);
     System.out.println("result1 : "+ list1 +" ===> "+ results1);

     Set<String> results2 = new HashSet<String>(allWords);
     results2.removeAll(list2);
     System.out.println("result2 : "+ list2 +" ===> "+ results2);

     Set<String> results3 = new HashSet<String>(allWords);
     results3.removeAll(list3);
     System.out.println("result3 : "+ list3 +" ===> "+ results3);