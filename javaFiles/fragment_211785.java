public List getAllMant() 
{        
    ArrayList<Map<String,String>> mant = new ArrayList<Map<String,String>>();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(this.query);

        campos = this.getCampos();
        while (rs.next()) {
            LinkedHashMap<String, String> row = new LinkedHashMap<String, String>();
            for(List<String> campo: campos){            
                String valueField = "";
                if( Arrays.asList(INTS).contains(Integer.parseInt(campo.get(1)) ) ){
                    valueField = String.valueOf(rs.getInt(campo.get(0)));
                } else if( Arrays.asList(NUMBERS).contains(Integer.parseInt( campo.get(1)) ) ){
                    valueField = String.valueOf(rs.getLong(campo.get(0)));
                } else if( Arrays.asList(VARCHAR).contains(Integer.parseInt( campo.get(1)) ) ){
                    valueField = rs.getString(campo.get(0)) ;
                } else if( Arrays.asList(DATES).contains(Integer.parseInt( campo.get(1)) ) ){
                    if(rs.getDate(campo.get(0)) !=null){
                        valueField = rs.getDate(campo.get(0)).toString();
                    } else{
                        valueField = "";
                    }
                }
                row.put(campo.get(0),valueField);
            }
            mant.add(row);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return mant;
}