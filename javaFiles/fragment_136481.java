package me.heirteir.Amazed.gameObjects.framework;

import com.badlogic.gdx.utils.Array;

public class Lanes {
    public static final int LANE_COUNT = 5;
    public static Array<Lane> lanes = new Array<Lane>();

    public static void setupLanes(float width, float height) {
    for (int x = 0; x < 5; x++) {
        lanes.add(new Lane(width / LANE_COUNT, height, width / LANE_COUNT * x + 1, height));
    }
   }
}