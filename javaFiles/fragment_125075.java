//Problem 1: we don't know the type of the values, i.e. we could put anything for "id" etc.
Map<String, Object> story1=new HashMap<>();
story1.put("id", 1);
story1.put("title", "Onboarding");
story1.put("keyword","new joinee");
story1.put("targeting","finance");

Map<String, Object> story2=new HashMap<>();
story2.put("id", 1);
story2.put("title", "Onboarding");
story2.put("keyword","training");
story2.put("targeting","HR");

List<Map<String, Object>> stories=new ArrayList<>();

stories.add(story1);
stories.add(story2);

Map<Integer, Map<String, Object>> combined = new HashMap<>();

stories.forEach((story) -> {
  //Problem 2: because we don't know the type of the values we need a lot of nasty casts
  Map<String, Object> combinedStory = combined.computeIfAbsent( (Integer)story.get( "id" ), k -> new HashMap<String, Object>() );
  combinedStory.put("id", story.get( "id" ) );
  combinedStory.put("title", story.get( "title" ) );

  //Problem 3: the combined map would look a lot like your "story" maps but would contain different types
  ((List<String>)combinedStory.computeIfAbsent( "keyword", v -> new List<String>() )).add( (String)story.get("keyword") );
  ((List<String>)combinedStory.computeIfAbsent( "targeting", v -> new List<String>() )).add( (String)story.get("targeting") );
});