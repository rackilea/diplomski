if (sender instanceof Player)
        {
            Particle particle = new Particle();
            Player player = (Player) sender;
            double x = ((Player) sender).getLocation().getX();
            double y = ((Player) sender).getLocation().getY();
            double z = ((Player) sender).getLocation().getZ();
            World w = sender.getWorld();
            w.spawnParticle(org.bukkit.Particle.TOTEM, x, y, z, 1, 0, 0, 0);

        }