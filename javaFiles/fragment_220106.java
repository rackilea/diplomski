void login(String file, String userName, String password) throws IOException {
    Map<String, String> map = Files.lines(Paths.get(file))
        .map(line -> line.split("=", 2))
        .filter(array -> array.length == 2)
        .collect(Collectors.toMap(
                array -> array[0].trim(),
                array -> array[1].trim()));
    if (map.get("User name").equals(userName)
            && map.get("Password").equals(password)) {
        System.out.println("details are correct!!");
    } else throw new RuntimeException("Details are not correct!");
}