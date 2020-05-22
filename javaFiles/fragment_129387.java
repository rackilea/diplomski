HashMap<String, Integer> firstNameCountMap = new HashMap<String, Integer>();
for (String firstName : first) {
    if (firstNameCountMap.containsKey(firstName)) 
        firstNameCountMap.put(firstName, firstNameCountMap.get(firstName)++);
    else
        firstNameCountMap.put(firstName, 0);
}
System.out.println("******* First Names count*********");
for (String firstName : firstNameCountMap.keySet()) {
    System.out.println(firstName + " " + firstNameCountMap.get(firstName));
}