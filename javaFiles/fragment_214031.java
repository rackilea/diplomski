StringBuilder sb = new Stringuilder();
    while (rs.next()){
        sb.append(rs.getString("category")+"\n");
    } 
    rs.close();
    ta_results.setText(sb.toString());