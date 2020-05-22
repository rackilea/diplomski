public void cast(Player caster){
    Location loc = caster.getTargetBlock(null, 512).getLocation();
    for (int c = -3; c < 3; c++)
        for (int b = -1; b < 5; b++)
            for (int a = -3; a < 3; a++) {
                Block ice = caster.getWorld().getBlockAt(loc.add(a, b, c));
                ice.setTypeId(79);
                loc = loc.subtract(a, b, c);
            }
}