Thread mainThread;

public DreamStatsTracker(){
    mainThread = new Thread(() -> {
        while(true){
            for (SkillAndValue skillAndValue : Skills) {
                try {
                    SetValueForSkill(this.SessionId, skillAndValue.getSkill(), skillAndValue.getValue());
                    System.out.println("Added value: " + skillAndValue.getValue());
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    });

}

public void AddSkillAndValue(Skill Skill, Callable<Integer> function) throws Exception{
    Skills.add(new SkillAndValue(Skill, function));
}

public void Start(){
    for (SkillAndValue skillAndValue : Skills) {
        AddSkill(this.SessionId, skillAndValue.getSkill(), this.Username);
    }
    this.mainThread.start();
}