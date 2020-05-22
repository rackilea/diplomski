List<String[]> userList = new ArrayList<>();
userList.add(new String[]{"George","123"});
userList.add(new String[]{"George","123"});
userList.add(new String[]{"George","456"});
List<String[]> userListNoDupes = new ArrayList<>(userList.stream()
    .collect(Collectors.toMap(arr-> arr[1], Function.identity(), (a,b)-> a)).values());
for(String[] user: userListNoDupes) {
    System.out.println(Arrays.toString(user));
}