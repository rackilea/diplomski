public enum HitboxType {
    ANGRY
}

public final class HitboxFactory {
    private HitboxFactory() {
    }

    public static Hitbox createHitbox(HitboxType hitboxType) {
        switch(hitboxType) {
            case HitboxType.ANGRY:
                return new AngryHitbox();
            case <another_case>:
                return <respective hitbox>
        }
        //in case of invalid parameter
        return null;
    }
}