public class implem implements extension {
    private String Home;
    private String Visit;

    @Override
    public String HomeTeamScored() {
        return Home;
    }

    @Override
    public String VisitingTeamScored() {
        return Visit;
    }

    @Override
    public void setHomeTeam(String name) {

    }

    public void setHome(String Home) {
        this.Home = Home;
    }

    public void setVisit(String Visit) {
        this.Visit = Visit;
    }

    @Override
    public void setVisitingTeam(String name) {

    }

    @Override
    public String FinalScore() {

        return null;
    }
}