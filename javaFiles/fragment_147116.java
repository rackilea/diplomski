try {
        ResultSet rs = stat.executeQuery("select * from schedule");
        List<String[]> list = new ArrayList<>();
        while (rs.next()) {
            String show = rs.getString("SHOW");
            String season = rs.getString("SEASON");
            list.add(new String[]{show, season});
        }
    } 
    catch (Exception e) {
        e.printStackTrace();
    }