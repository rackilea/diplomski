while (line != null){
    Entity uptime = new Entity("Uptime"); // remove the declaration/initialization from before, create a new every loop
    uptime.setProperty("timestamp", timestamp);
    uptime.setProperty("value",  line);
    datastore.put(uptime);
    //Ouput for Debug purpose
    out.println("COUNT: " + n + " LINE: " + line);
    n++;

    line = buff.readLine();
}