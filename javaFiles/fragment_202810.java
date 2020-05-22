public static void main(String[] args) throws Exception {

    DreamStatsTracker tracker = new DreamStatsTracker();

    tracker.StartNewSession("ae-13s-90-11", "Abe");

    tracker.AddSkillAndValue(Skill.HERBLORE, getRandomNumber());

    tracker.Start();

}

private static Callable<Integer> getRandomNumber(){
    return new Callable<Integer>(){
        public Integer call(){
            Random random = new Random();
            return random.nextInt(10000);
        }
    };
}