Story story1=new Story( 1 );
story1.title = "Onboarding";
story1.keyword = "new joinee";
story1.targeting = "finance";

Story story2=new Story( 1 );
story2.title = "Onboarding";
story2.keyword = "training";
story2.targeting = "HR";

List<Story> stories=new ArrayList<>();

stories.add(story1);
stories.add(story2);

Map<Integer, MultiStory> combined = new HashMap<>();

stories.forEach((story) -> {
  MultiStory multiStory = combined.computeIfAbsent( story.id, v -> new MultiStory( story.id ) );
  multiStory.title = story.title;
  multiStory.keywords.add( story.keyword );
  multiStory.targetingInfo.add( story.targeting );
});