Comparator<String> priorityFileComparator = Comparator.comparing(
    String::toString, (s1, s2) -> {         
        char s1Priority = s1.substring(5, 6).charAt(0);
        char s2Priority = s2.substring(5, 6).charAt(0);

        if (Character.isAlphabetic(s1Priority) && !Character.isAlphabetic(s2Priority)){
          return -1;            
        }

        if (Character.isAlphabetic(s2Priority) && !Character.isAlphabetic(s1Priority)){
          return 1;
        }

        return s1.compareTo(s2); // same nature -> lexicographical comparison
    });