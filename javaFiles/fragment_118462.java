public static int rest(String r) {

     if (r.length() >= 9) {
        int e = (Integer.parseInt(r.substring(0,9)) % 97);
        r = Integer.toString(e) + r.substring(9);
        return rest(r);
     }
     if(r.length() < 9)
        return (Integer.parseInt(r.substring(0)) % 97);
}