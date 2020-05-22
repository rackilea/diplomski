if (sender.hasPermission("justexplode.timer")) { // if player has permission, if not - bypass the timer.
    if (!canExplode(sender)) {
        // you can't explode yet :/
        return;
    }
    setLastExplodeUse(sender, System.currentTimeMillis() + 10 * 1000); // set the till time to explode use. Current time + 10000, 10000 = 10 seconds.
}
// there you can do your explosion etc.