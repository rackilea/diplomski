public class Test {

    public static void main(String[] args) {
        Team team = new Team(Arrays.asList(new Player[] {
            new Player("Peter", "Jensen", 24),
            new Player("Foo", "Bar", 50)
        }));
        System.out.println(team.averageAge()); // 37
    }
}