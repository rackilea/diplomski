class Skill {
    ...
}

public enum SkillType {
    Basic(new Skill(...)),
    SpeedBuff(new Skill(...)),
    Leap(new Skill(...)),
    ...

    private final Skill skill;

    public SkillType(Skill skill) {
        this.skill = skill;
    }

    public Skill getSkill() {
        return skill;
    }
}