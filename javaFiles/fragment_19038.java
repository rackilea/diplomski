Set<String> set1 = new HashSet<String>(Arrays.asList(user1_hobbies.split(" ")));
Set<String> set2 = new HashSet<String>(Arrays.asList(user2_hobbies.split(" ")));
set1.retainAll(set2);

if (set1.size() > 0) {
    System.out.println("There was a match.");
}
else {
    System.out.println("There were no matches.");
}