package me.Pixel;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.scheduler.BukkitTask;

public class LightningShot {
    private static int interval = 5;

    Arrow arrow;
    int tick = interval;

    public LightningShot(Arrow a) {
        arrow = a;

        BukkitTask[] task = new BukkitTask[1];
        task[0] = Bukkit.getScheduler().runTaskTimerAsynchronously(Main.plugin, new Runnable() {
            @Override
            public void run() {
                if (arrow == null || arrow.isOnGround() || arrow.isDead() || tick >= 200) {
                    System.out.println("Stopping...");
                    task[0].cancel();
                } else {
                    tick += interval;
                    System.out.println("Launching Lightning...");
                    Location loc = arrow.getLocation();
                    System.out.println("At " + loc.getWorld().getName() + " " + loc.getX() + "/"+ loc.getY() + "/" + loc.getZ());
                    loc.getWorld().strikeLightning(arrow.getLocation());
                }
            }
        }, interval, interval);
    }
}