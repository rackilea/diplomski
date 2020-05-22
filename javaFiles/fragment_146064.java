String m = brm.readLine();   
String g = brg.readLine();

while (m != null && g != null) {
    // check if contains # and write otherwise
    if(!m.contains("#") && !g.contains("#")) {
        bru.write(m + ";" + g.split(";")[1] + "\n");
    }
    m = brm.readLine();
    g = brg.readLine();
}