Multimap <String, Integer> students = ArrayListMultimap<String, Integer>.create();
students.put(name1, mark1);
students.put(name1, mark2);
students.put(name2, mark3);
students.put(name2, mark4);
Collection <Integer> marks1 = students.get (name1);
Collection <Integer> marks2 = students.get (name2);