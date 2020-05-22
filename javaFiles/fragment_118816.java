Set<String> s1 = new HashSet<String>(Arrays.asList(new String[] {"tom", "dick", "harry", "john", "smith", "dick"}));
Set<String> s2 = new HashSet<String>(Arrays.asList(new String[] {"Rachel", "dick", "tom", "dick", "smith", "harry", "Orion"}));

s1.retainAll(s2);  // s1 becomes the intersection of s1 & s2

System.out.println("Number of common elements: " + s1.size());