Collections.sort(students, (s1, s2) ->
        s1.getName().compareTo(s2.getName())); // for String values


Collections.sort(students, (s1, s2) ->
        Integer.compare(s1.getRollNumber(), s2.getRollNumber())); // for Integral values