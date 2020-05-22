int apptHour = 8, apptMin = 45; // appointment is 8:45

String arrivalTime = ""; // temp var to store latest acceptable arrival time

String times = "7:00 7:30 8:00 8:30 9:00 9:30"; 
String[] time = times.split(" "); // split your string "7:00 7:30 8:00" etc.

for (String s : time) {
    String[] parts = s.split(":"); // split each time into hours and mins

    // if appointment is on the hour, remove 1 minute so that we calculate the correct arrival
    if (apptMin == 0) { apptHour--; apptMin = 59; }

    if (Integer.parseInt(parts[0]) == apptHour) {
        if (Integer.parseInt(parts[1]) < apptMin) {
            arrivalTime = parts[0] + ":" + parts[1]; 
        }
    }
}
System.out.println(arrivalTime);