String mainBlock = "<ul class=\"Bold\">                                <li class=\"ball-orange\">2</li>                                <li class=\"ball-orange\">10</li>                                <li class=\"ball-orange\">11</li>                                <li class=\"ball-orange\">15</li>                                <li class=\"ball-orange\">22</li>                                <li class=\"ball-orange\">39</li>                            </ul>";
    Pattern listPattern = Pattern.compile("<li class=\"ball-orange\">([0-9]{1,2})</li>");
    Matcher matcher = listPattern.matcher(mainBlock);
    while (matcher.find()) {
        System.out.println("whole thing: " + matcher.group()); // or group(0)
        System.out.println("number: " + matcher.group(1));
    }