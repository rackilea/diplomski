public class Helper {

    public String stringify(List<Marker> l) {
        String rs = "";
        for (Marker marker : l) {
            rs = rs + ',' + marker.toString();
        }
        rs.substring(1);
        return rs;
    }

    public List<Marker> makeList(String rs){
        List<Marker> rl = new LinkedList<Marker>();
        String[] a = rs.split(",");
        for (String string : a) {
            Marker rm = new Marker();
            // I don't know what class of marker you use, 
            //but here you should create the marker from the string
            rl.add(rm);
        }
        return rl;
    }

}