while(rs.next()){
    Object[] row = new Object[]{rs.getInt(1), 
                    rs.getString(2), 
                    rs.getString(3), 
                    rs.getString(4),
                    rs.getDouble(5),
                    rs.getInt(6),
                    rs.getInt(7)};
    data.add(row);
}
Object[][] realData = data.toArray(new Object[data.size()][]);