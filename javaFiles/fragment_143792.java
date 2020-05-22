RestAdapter restAdapter = new RestAdapter.Builder() 
      .setEndpoint("https://api.github.com")
      .build(); 

GitHubService service = restAdapter.create(GitHubService.class);

List<Repo> repos = service.listRepos("octocat");