@EventHandler
fun onPortalEvent(e: PlayerPortalEvent) {
    if (e.from == X) { //Where X is the location that you know the player is, use the world name or whatever you need
        e.setTo(Y) //Where Y is the location you want the TP to go to
    }
}