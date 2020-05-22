resId = new JTextField();
    try{
        rs = stt.executeQuery("select max(ReservID) as last_id from passenger");
        if(rs.next()){
        int lastid = rs.getInt("last_id");
        lastid++;
        resId.setText(String.valueOf(last_id));
        }

    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "cannot retrieve");
    }