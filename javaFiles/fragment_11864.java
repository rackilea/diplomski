public class Man extends Human {

    protected String soccerTeam;

    public static class ManBuilder extends HumanBuilder<Man, ManBuilder> {

        protected String soccerTeam;

        public ManBuilder soccerTeam(String soccerTeam) {
            this.soccerTeam = soccerTeam;
            return this;
        }

        @Override
        protected void fill(Man man) {
            super.fill(man);
            man.soccerTeam = this.soccerTeam;
        }

        @Override
        protected Man create() {
            return new Man();
        }
    }
}