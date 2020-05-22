stmt.executeUpdate(
  "INSERT INTO user_ip(uid,ip) "+
  "SELECT DISTINCT email,ip FROM temp "+
  "   LEFT JOIN user_id ON "+
  "      (temp.email = user_ip.email AND temp.ip = user_ip.ip) "+
  "    WHERE user_ip.email IS NULL");