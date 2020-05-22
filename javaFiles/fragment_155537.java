ResultSet resultttt = stmtttt.executeQuery("select * from logs_pms_t_project where p_id="+p_id+" ");
String phase_id = null;
if (resultttt.next()) {
    phase_id = resultttt.getString("phase_id");
    // out.println ... ?
}