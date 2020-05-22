public static void buildPyramid(Location l) {
    Location pos;
    for(int i = -2; i <= 2; i++) {
        for(int j = -2; j <= 2; j++) {
            pos = l.clone().add(i, 0, j);
            Bukkit.broadcastMessage(Math.abs(i) + Math.abs(j) + ""); // for test
            int diff = Math.abs(i) + Math.abs(j);
            switch(diff) {
                case 2:
                    pos.getBlock().setType(Material.BEDROCK);
                    break;
                case 1:
                    pos.getBlock().setType(Material.BEDROCK);
                    pos.add(0, 1, 0);
                    pos.getBlock().setType(Material.BEDROCK);
                    pos.add(0, -1, 0);
                    break;
                case 0:
                    pos.getBlock().setType(Material.BEDROCK);
                    pos.add(0, 1, 0);
                    pos.getBlock().setType(Material.BEDROCK);
                    pos.add(0, 1, 0);
                    pos.getBlock().setType(Material.BEDROCK);
                    pos.add(0, -2, 0);
                    break;
                default:
                    break;

            }
        }
    }
}