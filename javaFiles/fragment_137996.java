enum limbs {legs,thighs,torso,arms1,arms2,head};

public static void main(String[] args) throws Exception {

    for (limbs limb : limbs.values()){
        player.get(limb.toString()).setPosition(
            playerInfo.get(limb.toString()).getPos().x,   playerInfo.get(limb.toString()).getPos().y   );
    }
}