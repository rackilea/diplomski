public static Date addDaysToCurrentDate(int days) {
     SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
     Calendar c = Calendar.getInstance();
     c.setTime(new Date()); 
     c.add(Calendar.DATE, days); 
     return sdf.parse(c.getTime());
}

ps = c.prepareStatement("INSERT INTO tablename (uuid, pool, expires) VALUES (?, ?, ?)");
ps.setString(1, player.getUniqueId().toString());
ps.setInt(2, plugin.s.DEFAULT_POOL);
ps.setInt(3, addDaysToCurrentDate(plugin.s.PAYMENT_DAYS));