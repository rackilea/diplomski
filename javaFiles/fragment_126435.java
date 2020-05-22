// Server code
public void addPlayer(MPlayer pl, Login00 l) {
    boolean ac = false;
    for (MPlayer p : cplayers) {
        // At this point, you overwrite all existing player data
        p.ip = pl.ip; // overwrites existing player
        p.port = pl.port; // overwrites existing player
        if (Main.username.equalsIgnoreCase(l.getUser())) {
            ac = true;
        } else {
            sendDataAll(l.getData());
            Login00 ll = new Login00(p.user);
            sendData(ll.getData(), p.ip, p.port);
        }
    }
}