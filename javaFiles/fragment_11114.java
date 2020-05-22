Long future_time = System.currentTimeMillis() + 3600000;
"https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&" +
                        "origins=" + startLat +"," + startlong  +
                        "&destinations=" + endLat +","+endLong +
                        //departure_time parameter
                        "&departure_time=" + future_time +
                        "&key=my api key");