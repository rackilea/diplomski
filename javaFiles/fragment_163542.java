PersonalityInsights service = new PersonalityInsights();
service.setUsernameAndPassword("<username>", "<password>");
service.setEndPoint("https://gateway.watsonplatform.net/personality-insights/api")

String text = "your text goes here...."
ProfileOptions options = new ProfileOptions.Builder()
  .text(text)
  .build();

Profile profile = service.profile(options).execute();
System.out.println(profile);