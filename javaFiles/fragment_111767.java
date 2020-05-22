if(csvLength > 43 && (null != csvRead[43] && !csvRead[43].trim().equals(""))){

        pstmt.setFloat(45,Float.parseFloat((csvRead[43].replace("\"\"","0")).toString()));
        }else{

        pstmt.setNull(45,Types.INTEGER);
}