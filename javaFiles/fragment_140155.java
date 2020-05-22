long total = 0L;
while (vp.next()) {
    lat = vp.getFloat("latitude");
    lon = vp.getFloat("longitude");

    if (lat >= Wb_SWLat && lat <= Wb_NELat && 
        lon >= Wb_SWLon && lon <= Wb_NELon) {

        westPty = Vp.getInt("priority");
        System.out.println("West Priority:"+WestPty);

        total += westPty;
    }
}

System.out.println("Total west priority: " + total);