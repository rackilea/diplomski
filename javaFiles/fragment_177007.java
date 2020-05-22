package test;

import java.util.Comparator;

public class ScoreBasedComparator implements Comparator<PlayerInfo> {

    @Override
    public int compare(final PlayerInfo playerInfo1, final PlayerInfo playerInfo2) {
        return playerInfo1.getScore().compareTo(playerInfo2.getScore());
    }

}