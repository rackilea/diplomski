package GamerProject;

import java.io.Serializable;
import java.util.Comparator;

public class Gamer implements Serializable, Comparable<Gamer> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String playerName;
    private static final int HEALTH_POINTS_RESD = 23;
    private static final int AREAS_VISITED = 200;
    private static final int PLAYERS_ENCOUNTERED = 175;
    private static final int MAPS_CREATED = 1500;
    private static final int ITEMS_GATHERED = 20;
    private static final int ITEMS_REPAIRED = 100;
    private static final int ITEMS_MERGED = 125;
    private static final int TOP_SCORES = 250;
    private static final int DMG_POINTS_DEALT = 17;
    private static final int MAPS_COMPLETED = 750;
    private static final int LEVEL2 = 10000;
    private static final int LEVEL3 = 25000;
    private static final int LEVEL4 = 80000;
    private static final int LEVEL5 = 150000;
    private static final int LEVEL6 = 300000;
    private static final int LEVEL7 = 1000000;
    private static final int LEVEL8 = 2200000;
    private static final int LEVEL9 = 4500000;
    private static final int LEVEL10 = 10000000;
    private static final int LEVEL11 = 20000000;
    private static final int LEVEL12 = 35000000;
    private final int[] gamerStatValues = new int[10];
    private final int[] gamerActions = {HEALTH_POINTS_RESD, AREAS_VISITED, PLAYERS_ENCOUNTERED, MAPS_CREATED,
        ITEMS_GATHERED, ITEMS_REPAIRED, ITEMS_MERGED, TOP_SCORES, DMG_POINTS_DEALT, MAPS_COMPLETED};
    private final int[] expValues = {LEVEL2, LEVEL3, LEVEL4, LEVEL5, LEVEL6, LEVEL7,
        LEVEL8, LEVEL9, LEVEL10, LEVEL11, LEVEL12};
    private final int[][] badgePoints = {
        {0, 2000, 10000, 30000, 100000, 200000},
        {0, 50, 1000, 5000, 17000, 40000},
        {0, 100, 1000, 2000, 10000, 30000},
        {0, 3, 10, 20, 90, 150},
        {0, 2000, 10000, 30000, 100000, 200000},
        {0, 100, 1000, 5000, 15000, 40000},
        {0, 100, 500, 2000, 10000, 40000},
        {0, 20, 200, 1000, 5000, 20000},
        {0, 2000, 10000, 30000, 100000, 300000},
        {0, 10, 50, 200, 500, 5000}};
    private final String[] badgeTitles = {"Healer: ", "Explorer: ", "Socialite: ", "Contributor: ",
        "Hoarder: ", "Fixer: ", "Joiner: ", "Leader: ", "Punisher: ", "Obsessed: ",};
    private final String[] badgeRanks = {"No Badge ", "Tin ", "Bronze ", "Silver ", "Gold ", "Platinum "};

    Gamer() {
        playerName = "";

    }

    public int getTotalExp() {
        int totalExp = 0;
        for (int i = 0; i < gamerStatValues.length; i++) {
            totalExp += (gamerStatValues[i] * gamerActions[i]);
        }
        return totalExp;
    }

    public int getLevel() {
        int playerLevel = 1;
        int totalExp = getTotalExp();
        for (int i = 0; i < expValues.length; i++) {
            if (totalExp >= expValues[i]) {
                playerLevel += 1;
                //System.out.println(getTotalExp());
            }
        }
        return playerLevel;
    }

    public String getBadge(int requestedStat) {
        String badgeOutput = "";
        //index = 0;
        if (requestedStat >= 0 && requestedStat <=9) {
            for (int i = 0; i < badgeRanks.length; i++) {//not sure how to get around going out of the array bounds
                if (gamerActions[requestedStat] >= badgePoints[requestedStat][i]
                        && gamerActions[requestedStat] < badgePoints[requestedStat][i + 1]) {
                    badgeOutput = badgeTitles[requestedStat] + badgeRanks[i];
                } else if (gamerActions[requestedStat] >= badgePoints[requestedStat][i+1]
                        && gamerActions[requestedStat] < badgePoints[requestedStat][i + 2]) {
                    badgeOutput = badgeTitles[requestedStat] + badgeRanks[i+1];
                }
            }
            //did this as an extraneous solution. Still doesn't work
//            if (gamerActions[requestedStat] >= badgePoints[requestedStat][index]
//                        && gamerActions[requestedStat] < badgePoints[requestedStat][index + 1]) {
//                    badgeOutput = badgeTitles[requestedStat] + badgeRanks[index];
//                } else if (gamerActions[requestedStat] >= badgePoints[requestedStat][index+1]
//                        && gamerActions[requestedStat] < badgePoints[requestedStat][index + 2]) {
//                    badgeOutput = badgeTitles[requestedStat] + badgeRanks[index+1];
//                } else if (gamerActions[requestedStat] >= badgePoints[requestedStat][index+2]
//                        && gamerActions[requestedStat] < badgePoints[requestedStat][index + 3]) {
//                    badgeOutput = badgeTitles[requestedStat] + badgeRanks[index+2];
//                } else if (gamerActions[requestedStat] >= badgePoints[requestedStat][index+3]
//                        && gamerActions[requestedStat] < badgePoints[requestedStat][index + 4]) {
//                    badgeOutput = badgeTitles[requestedStat] + badgeRanks[index+3];
//                } else if (gamerActions[requestedStat] >= badgePoints[requestedStat][index+4]
//                        && gamerActions[requestedStat] < badgePoints[requestedStat][index + 5]) {
//                    badgeOutput = badgeTitles[requestedStat] + badgeRanks[index+4];
//                } else if (gamerActions[requestedStat] >= badgePoints[requestedStat][index+5]
//                        && gamerActions[requestedStat] < badgePoints[requestedStat][index + 6]) {
//                    badgeOutput = badgeTitles[requestedStat] + badgeRanks[index+5];
//                } else {
//                    badgeOutput = badgeTitles[requestedStat] + badgeRanks[index+6];
//                }
//            

        } else {
            badgeOutput = "No Badges Available";
        }
        return badgeOutput;
    }

    //Incomplete Method
    public String getBadges() {
        String badgeOutput = "Badges: ";
        for (int i = 0; i < badgeTitles.length; i++) {
//            if (gamerActions[i]) {
//                
//            }
        }

        return badgeOutput;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getHealthPointsResd() {
        return gamerStatValues[0];
    }

    public int getAreasVisited() {
        return gamerStatValues[1];
    }

    public int getPlayersEncountered() {
        return gamerStatValues[2];
    }

    public int getMapsCreated() {
        return gamerStatValues[3];
    }

    public int getItemsGathered() {
        return gamerStatValues[4];
    }

    public int getItemsRepaired() {
        return gamerStatValues[5];
    }

    public int getItemsMerged() {
        return gamerStatValues[6];
    }

    public int getTopScores() {
        return gamerStatValues[7];
    }

    public int getDmgPointsDealt() {
        return gamerStatValues[8];
    }

    public int getMapsCompleted() {
        return gamerStatValues[9];
    }

    //Unused Method
    public void updateRandomGamerAction(int intValue) {
        if (intValue == 0) {
            gamerActions[0]+=1;
        } else if (intValue == 1) {
            gamerActions[1]+=1;
        } else if (intValue == 2) {
            gamerActions[2]+=1;
        } else if (intValue == 3) {
            gamerActions[3]+=1;
        } else if (intValue == 4) {
            gamerActions[4]+=1;
        } else if (intValue == 5) {
            gamerActions[5]+=1;
        } else if (intValue == 6) {
            gamerActions[6]+=1;
        } else if (intValue == 7) {
            gamerActions[7]+=1;
        } else if (intValue == 8) {
            gamerActions[8]+=1;
        } else {
            gamerActions[9]+=1;
        }
    }

    public String setPlayerName(String playerName) {
        this.playerName = playerName;
        return this.playerName;
    }

    public int setHealthPointsResd(int healthPointsResd) {
        if (healthPointsResd >= 0) {
            gamerStatValues[0] = healthPointsResd;
            return gamerStatValues[0];
        } else {
            return gamerStatValues[0];
        }
    }

    public int setAreasVisited(int areasVisited) {
        if (areasVisited >= 0) {
            gamerStatValues[1] = areasVisited;
            return gamerStatValues[1];
        } else {
            return gamerStatValues[1];
        }
    }

    public int setPlayersEncountered(int playersEncountered) {
        if (playersEncountered >= 0) {
            gamerStatValues[2] = playersEncountered;
            return gamerStatValues[2];
        } else {
            return gamerStatValues[2];
        }
    }

    public int setMapsCreated(int mapsCreated) {
        if (mapsCreated >= 0) {
            gamerStatValues[3] = mapsCreated;
            return gamerStatValues[3];
        } else {
            return gamerStatValues[3];
        }
    }

    public int setItemsGathered(int itemsGathered) {
        if (itemsGathered >= 0) {
            gamerStatValues[4] = itemsGathered;
            return gamerStatValues[4];
        } else {
            return gamerStatValues[4];
        }
    }

    public int setItemsRepaired(int itemsRepaired) {
        if (itemsRepaired >= 0) {
            gamerStatValues[5] = itemsRepaired;
            return gamerStatValues[5];
        } else {
            return gamerStatValues[5];
        }
    }

    public int setItemsMerged(int itemsMerged) {
        if (itemsMerged >= 0) {
            gamerStatValues[6] = itemsMerged;
            return gamerStatValues[6];
        } else {
            return gamerStatValues[6];
        }
    }

    public int setTopScores(int topScores) {
        if (topScores >= 0) {
            gamerStatValues[7] = topScores;
            return gamerStatValues[7];
        } else {
            return gamerStatValues[7];
        }
    }

    public int setDmgPointsDealt(int dmgPointsDealt) {
        if (dmgPointsDealt >= 0) {
            gamerStatValues[8] = dmgPointsDealt;
            return gamerStatValues[8];
        } else {
            return gamerStatValues[8];
        }
    }

    public int setMapsCompleted(int mapsCompleted) {
        if (mapsCompleted >= 0) {
            gamerStatValues[9] = mapsCompleted;
            return gamerStatValues[9];
        } else {
            return gamerStatValues[9];
        }
    }

    public void setStatsToZero(){
        for (int i = 0; i < gamerActions.length; i++) {
            gamerActions[i] = 0;
        }
    }
    public String statsString() {
        return "Stats: " + "Health Points Restored = " + gamerStatValues[0]
                + ",\n Areas Visited = " + gamerStatValues[1] + ", PlayersEncountered = " + gamerStatValues[2]
                + ", Maps Created = " + gamerStatValues[3] + ",\n Items Gathered = " + gamerStatValues[4]
                + ", Items Repaired = " + gamerStatValues[5] + ", Items Merged = " + gamerStatValues[6]
                + ",\n Top Scores = " + gamerStatValues[7] + ", Damage Points Dealt =  " + gamerStatValues[8]
                + ", Maps Completed = " + gamerStatValues[9] + '}';
    }

    public String shortDecription() {
        return String.format("%16s: Level %2d, Experience Points: %,10d",
                playerName, this.getLevel(), this.getTotalExp());
    }

    @Override
    public String toString() {
        return "Gamer{" + "Player Name = " + playerName + " Player Stats: "
                + "Health Points Restored = " + gamerStatValues[0]
                + ",\n Areas Visited = " + gamerStatValues[1] + ", PlayersEncountered = " + gamerStatValues[2]
                + ", Maps Created = " + gamerStatValues[3] + ",\n Items Gathered = " + gamerStatValues[4]
                + ", Items Repaired = " + gamerStatValues[5] + ", Items Merged = " + gamerStatValues[6]
                + ",\n Top Scores = " + gamerStatValues[7] + ", Damage Points Dealt =  " + gamerStatValues[8]
                + ", Maps Completed = " + gamerStatValues[9] + '}';
    }

    @Override
    public int compareTo(Gamer player) {
        if (this.getTotalExp() > player.getTotalExp()) {
            return 1;
        } else if (this.getTotalExp() == player.getTotalExp()) {
            return 0;
        } else {
            return -1;
        }
    }

}