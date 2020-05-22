public static int[][] generateNpcDrops(){
    return new int[][] {

    // Normal NPC's
    {1, 526, 1, ALWAYS}, 
    {2, 526, 1, ALWAYS}, 
    {3, 526, 1, ALWAYS}, 
    {1, 995, drop(1, 50), ALWAYS}, 
    {2, 995, drop(1, 50), ALWAYS},
    {3, 995, drop(1, 50), ALWAYS},

    // Moderate NPC's
    {9, 526, 1, ALWAYS}, 
    {9, 995, drop(250, 500), UNCOMMON},
    {9, 555, drop(2, 7), VERY_COMMON},
    {9, 995, drop(5, 50), VERY_COMMON},
    {9, 1050, 1, RARE}, 
    }
}

...

public void npcDeath() {
    int npc = 0;    
    if (npc == null)
        return;
    int[][] npcDrops = DropConfig.generateNpcDrops();
    for(npc = 0; npc < npcDrops.length; npc++) {
        if(npc == npcDrops[npc][0]) {
            if(Misc.random(npcDrops[npc][3]) == 0) { //Drops ALWAYS item
                Item(c, npcDrops[npc][1], npcDrops[npc][2]);
            }
        }
    }
}