enum limbs {legs,thighs,torso,arms1,arms2,head};

public static void main(String[] args) throws Exception {
    for (limbs limb : limbs.values()){
        player.get(limb).setPosition(
            playerInfo.get(limb).getPos().x,   playerInfo.get(limb).getPos().y   );
    }
}