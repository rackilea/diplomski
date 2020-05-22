package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Runner {

    public static void main(final String[] args) {
        List<PlayerInfo> playerInfos = new ArrayList<PlayerInfo>();
        playerInfos.add(new PlayerInfo("A", 123, 1));
        playerInfos.add(new PlayerInfo("B", 1, 2));
        playerInfos.add(new PlayerInfo("C", 23, 3));
        playerInfos.add(new PlayerInfo("D", 300, 4));
        Collections.sort(playerInfos, new ScoreBasedComparator());
        System.out.println(Arrays.toString(playerInfos.toArray()));
    }

}