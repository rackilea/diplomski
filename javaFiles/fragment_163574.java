boolean isApacheRunning = f.isServerUp(82);
boolean isMySqlRunning = f.isServerUp(3306);
JOptionPane.showMessageDialog(null, "Is tomcat Running = " + isApacheRunning + "\nIs mysql Running = " + isMySqlRunning);
            if (!isMySqlRunning){
                f.RunMySQL();
            }
            if (!isApacheRunning){
                f.RunApache();
            }