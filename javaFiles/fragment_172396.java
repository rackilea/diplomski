package me.Pixel;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.scheduler.BukkitTask;

public class LightningShot {

    Arrow arrow;
    int tick = 3;

    public LightningShot(Arrow a) {
        arrow = a;

        BukkitTask[] task = new BukkitTask[1];
        task[0] = Bukkit.getScheduler().runTaskTimerAsynchronously(Main.plugin, new Runnable() {
            @Override
            public void run() {
                if (arrow == null || arrow.isOnGround() || arrow.isDead() || tick >= 200) {
                    task[0].cancel();
                } else {
                    tick += 1;
                    Location loc = arrow.getLocation();
                    loc.getWorld().strikeLightning(arrow.getLocation());
                }
            }
        }, 3, 1);
    }
}