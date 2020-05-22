Properties props = new Properties();
props.setProperty("user", "root");
props.setProperty("password", "");
props.setProperty("useTimezone", "true");
props.setProperty("useLegacyDatetimeCode", "false");
props.setProperty("serverTimezone", "UTC");
Connection con = DriverManager.getConnection(conString, props);