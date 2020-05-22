SQL_Statement = "UPDATE GLOBALSETTINGS "
    + "SET SettingValue = "
    + "CASE "
    + "WHEN SettingName = 'SessionTTL' THEN ? "
    + "WHEN SettingName = 'MaxUsersActive' THEN ? "
    + "WHEN SettingName = 'TimestampFormat' THEN ? "
    + "END "
    + "WHERE SettingName  IN ('SessionTTL', 'MaxUsersActive', 'TimestampFormat')";