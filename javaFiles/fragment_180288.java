public static void getScores(){
     Leaderboard l = new Leaderboard("KEY");
     l.getScores(new Leaderboard.GetScoresCB() {

        @Override
        public void onSuccess(List<Score> scorelist) {
            // TODO Auto-generated method stub

        }
    });
 }