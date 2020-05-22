class NFLApplication {

    public static void main(String[] args) {      

            NFLPlayer playerStats = new NFLPlayer("johnson");    

            playerStats.setTouchdowns(2);
            playerStats.setPassingAttempts(44);
            playerStats.setPassingYards(285);
            playerStats.setInterceptions(1);
            playerStats.setCompletedPasses(35);

            double qbRating = playerStats.calculateQbRating();    

            System.out.println(qbRating);
        }
}