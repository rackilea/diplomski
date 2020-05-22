public static void main(String[] args) throws JsonProcessingException {

    RestTemplate rest = new RestTemplate();
    GitHubEmail[] gitHubEmails = rest.getForObject("https://api.myjson.com/bins/1h6ngn", GitHubEmail[].class);
    Arrays.stream(gitHubEmails)
        .forEach(gitHubEmail -> System.out.println(("GitHub email: " + gitHubEmail)));
}