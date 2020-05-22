PreparedStatement psmt = conn.prepareStatement("
    SELECT CASE WHEN val1 = ?
                THEN ''
                ELSE 'val1 changed from ' + val1 + ' to ' + ? + '\n'
           END CASE +
           CASE WHEN val2 = ?
                THEN ''
                ELSE 'val2 changed from ' + val2 + ' to ' + ? + '\n'
           END CASE +
           CASE WHEN val3 = ?
                THEN ''
                ELSE 'val3 changed from ' + val3 + ' to ' + ? + '\n'
           END CASE +
           CASE WHEN val4 = ?
                THEN ''
                ELSE 'val4 changed from ' + val4 + ' to ' + ? + '\n'
           END CASE AS logentry
    FROM tableName
    WHERE id=1
");
psmt.setString(1, myValue1);
psmt.setString(2, myValue1);
psmt.setString(3, myValue2);
psmt.setString(4, myValue2);
psmt.setString(5, myValue3);
psmt.setString(6, myValue3);
psmt.setString(7, myValue4);
psmt.setString(8, myValue4);
ResultSet rs = psmt.executeQuery();
String logentry = rs.getString("logentry");