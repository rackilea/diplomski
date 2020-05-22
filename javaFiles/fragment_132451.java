public interface IBonus {
    void fillStringList(List<String> values);
}
...

public void doWork(IBonus bonusObject){
   bonusObject.fillStringList(values);
}