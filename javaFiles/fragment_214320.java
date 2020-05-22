public interface IAnimal extends RealmModel {    
    int getNumberOfLegs();
    void setNumberOfLegs(int legs);
    boolean getHasFur();
    void setHasFur(boolean hasFur);
}

public interface IDog extends IAnimal {
    String getColor();
    void setColor(String color);
    boolean getCanDoTricks();
    void setCanDoTricks();
}

public interface IGermanShepherd extends IDog {
    boolean getIsGuardDog();
    void setIsGuardDog(boolean isGuardDog);
    boolean getIsAtRiskOfHipDysplasia();
    void setIsAtRiskOfHipDysplasia(boolean isAtRisk);
}