HashMap<String, String> postData = new HashMap<String, String>();
    HashMap<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
    headers.put("Accept-Encoding", "gzip, deflate, br");
    headers.put("Accept-Language", "en-US,en;q=0.9");
    headers.put("Cache-Control", "no-cache");
    headers.put("DNT", "1");
    headers.put("Pragma", "no-cache");
    headers.put("Upgrade-Insecure-Requests", "1");

    postData.put("qtype", "cpi");
    postData.put("sfw", "/FV/FlightTracker/Main");
    postData.put("namdep", "DFW Dallas, TX (Dallas/Ft Worth) - Dallas Fort Worth International");
    postData.put("depap", "DFW");
    postData.put("namarr", "JFK New York, NY (Kennedy) - John F Kennedy International");
    postData.put("arrap", "JFK");
    postData.put("namal2", "Enter name or code");
    postData.put("al", "");
    postData.put("whenArrDep", "dep");
    postData.put("whenHour", "all");
    postData.put("whenDate", "20180321");
    postData.put("input", "Track Flight");