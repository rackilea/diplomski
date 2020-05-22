public class MyStories extends JUnitStories {
    ...
    @Override
    protected List<String> storyPaths() {
        String storyName = System.getProperty("storyName");
        return new StoryFinder()
            .findPaths(codeLocationFromClass(embeddableClass).getFile(),
                       asList("**/" + storyName),
                       null);
    }
}