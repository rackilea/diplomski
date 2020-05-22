import java.awt.geom.Area;
...
boolean playerHitByTentacle(Tentacle t, Player p) {
    Area player = new Area(p.getPath2D());
    Area tentacle = new Area(t.getPath2D());
    player.intersect(tentacle);
    return !player.isEmpty();
}