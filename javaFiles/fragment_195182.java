private void updateData(String sql, String[] sqlValues) {
    BukkitRunnable r = new BukkitRunnable() {
        @Override
        public void run() {
            Database.execute( (conn) -> {
                PreparedStatement q = conn.prepareStatement(sql);
                q.setString(1, sqlValues[0]);
                q.setString(2, sqlValues[1]);
                System.out.println(q);
                q.executeUpdate();
            }} );
    };
    r.runTaskAsynchronously(instance);
}