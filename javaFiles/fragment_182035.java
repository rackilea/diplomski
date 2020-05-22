List<String> matchingProviders = myLocation.lm.getAllProviders();
    for (String provider: matchingProviders) 
    {
        Location location = myLocation.lm.getLastKnownLocation(provider);
        if (location != null) {
            float accuracy = location.getAccuracy();
            long time = location.getTime();

            if ((time > minTime && accuracy < bestAccuracy)) {
                bestResult = location;
                bestAccuracy = accuracy;
                bestTime = time;
            }
            else if (time < minTime && bestAccuracy == Float.MAX_VALUE && time > bestTime) {
                bestResult = location;
                bestTime = time;
            }
        }
    }