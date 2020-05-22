SimpleDateFormat sdf1 = new SimpleDateFormat("Myyyy");
    SimpleDateFormat sdf2 = new SimpleDateFormat("MMyyyy");
    Date d = null;
    if(5 == s.length()){
        d = sdf1.parse(s);
    }else if(6 == s.length()){
        d = sdf2.parse(s);
    }