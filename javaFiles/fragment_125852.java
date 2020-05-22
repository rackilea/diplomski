public static void main(String [] rags){
        UsernamePasswordProvider authProvider = new UsernamePasswordProvider("{client_id}", Arrays.asList("https://graph.microsoft.com/User.Read.All") , "{username}", "{password}", NationalCloud.Global, "{tenant}", "{cient_secret}");
        IGraphServiceClient graphClient = GraphServiceClient
                .builder()
                .authenticationProvider(authProvider)
                .buildClient();
        IUserCollectionPage userCollectionPage = graphClient.users().buildRequest().get();
        List<User> userList=userCollectionPage.getCurrentPage();
    }