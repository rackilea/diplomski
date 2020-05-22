public class Level {
    int levelId;

    public Level(int levelId) {
        this.levelId = levelId;
    }

    public static Level getLevel(String name){
        return new Level(name.length());
    }

    public int getLevelId() {
        return levelId;
    }

    public static void main(String[]args){
        Set<String> names=new HashSet<>();
        names.add("Mahesh");
        names.add("Ram");
        names.add("Rita");

        Comparator<Level> c = Comparator.comparingInt(Level::getLevelId);
        Map<Level, Set<String>> map = names.stream()
            .collect(Collectors.groupingBy(
                         Level::getLevel, () -> new TreeMap<>(c), Collectors.toSet()));
    }
}