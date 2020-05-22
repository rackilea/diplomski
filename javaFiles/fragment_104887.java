rs = database.
    executeQuery("Select group_concat(distinct alarmId) as alarmIds from alarms group by alarmDate having alarmDate = '"
                        + Alarm.getFormattedDateTime(DateFormat.FULL,
                                DateFormat.SHORT) + "'");
while (rs.next()) { // there will be only one result
    database.executeUpdate("update alarms set alarmStatus = '"+status+"' where alarmId in ("+rs.getString("alarmIds")+")");
}