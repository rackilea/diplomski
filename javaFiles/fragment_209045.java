package GamerProject;

import java.util.Random;

public class Program7Driver {

    private static final int rngRange = 10;
    private static final Gamer[] gamers = new Gamer[10];
    private static final String[] gamerNames = {"BestGamer99", "CdrShepardN7",
        "Gandalf_The_Cool", "SharpShooter01", "TheDragonborn", "SithLord01",
        "MrWolfenstien", "Goldeneye007", "DungeonMaster91", "MasterThief","TheDarkKnight"};



    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < gamers.length; i++) {
            gamers[i] = new Gamer();
            gamers[i].setPlayerName(gamerNames[i]);
            gamers[i].setStatsToZero();
        }
//        for (int i = 0; i < 200000; i++) {
//            int rng = rand.nextInt(rngRange);
//            gamers[rng].setRandomGamerAction(rng);
//        }
        int count = 0;
        for (int i = 0; i < gamers.length; i++) {
            int rng = rand.nextInt(rngRange);
            System.out.println(gamers[i]);
            //System.out.println(gamers[0].toString());
            //gamers[0].updateRandomGamerAction(rng);
            if (rng == 0) {
                gamers[0].setHealthPointsResd(gamers[0].getHealthPointsResd()+1);
            } else if (rng == 1) {
                gamers[0].setAreasVisited(gamers[0].getAreasVisited()+1);
            } else if (rng == 2) {
                gamers[0].setPlayersEncountered(gamers[0].getPlayersEncountered()+1);
            } else if (rng == 3) {
                gamers[0].setMapsCreated(gamers[0].getMapsCreated()+1);
            } else if (rng == 4) {
                gamers[0].setItemsGathered(gamers[0].getItemsGathered()+1);
            } else if (rng == 5) {
                gamers[0].setItemsRepaired(gamers[0].getItemsRepaired()+1);
            } else if (rng == 6) {
                gamers[0].setItemsMerged(gamers[0].getItemsMerged()+1);
            } else if (rng == 7) {
                gamers[0].setTopScores(gamers[0].getTopScores()+1);
            } else if (rng == 8) {
                gamers[0].setDmgPointsDealt(gamers[0].getDmgPointsDealt()+1);
            } else  {
                gamers[0].setMapsCompleted(gamers[0].getMapsCompleted()+1);
            }

            count += 1;
            if (count == 10) {
                count -= 10;
            }
           // System.out.println(gamers[i].statsString());     
        }
    }
}