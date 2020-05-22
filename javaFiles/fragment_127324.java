String[] matchSplit;
while (null != (match = sc.findWithinHorizon(timePattern, 0))) {
    matchSplit = match.split(":")
    double progress = Integer.parseInt(matchSplit[0]) * 3600 +
        Integer.parseInt(matchSplit[1]) * 60 +
        Double.parseDouble(matchSplit[2]) / totalSecs;
//...