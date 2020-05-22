OAuthService service = new ServiceBuilder()
    .provider(EvernoteApi.Sandbox.class)
    .apiKey("YOUR CONSUMER_KEY")
    .apiSecret("YOUR CONSUMER_SECRET")
    .callback("YOUR CALLBACK URL")
    .build();