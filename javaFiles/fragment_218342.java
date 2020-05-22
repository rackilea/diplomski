public final class StatisticA {
    public void DoSomeWork() {
        int differenceLevel = Caracteristic.B.getLevel() - Caracteristic.A.getLevel();
        string bothLevels = Caracteristic.A.toString() + " " + Caracteristic.B.toString();
        System.out.PrintLn(bothLevels + ": " + differenceLevel);
    }
}