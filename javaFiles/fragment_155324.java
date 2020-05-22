private static Map<String, Integer> findNumberOfPosts(List<String> userNameList) {
    Map<String, Integer> numberOfPosts = new HashMap<String, Integer>();

    for (String userName : userNameList) {
        Integer count = numberOfPosts.get(userName);
        numberOfPosts.put(userName, count == null ? 1 : ++count);
    }
    return numberOfPosts;
}