HttpsURLConnection con = utilities.GetResponse(url, urlParameters);
if(con == null) {
//stop processing or maybe throw an exception depending on what you want to do.
}
BufferedReader rd = null;

// Send post request
String line = "";
try{
    int responseCode = con.getResponseCode();  //what's this for? nothing is being done with the variable
    rd = new BufferedReader(new InputStreamReader(con.getInputStream()));

    while ((line = rd.readLine()) != null) {
        // Parse our JSON response
        responsString += line;
        JSONParser j = new JSONParser();
        JSONObject o = (JSONObject) j.parse(line);
        if (o.containsKey("response")) {
            restMessage = (Map) o.get("response");
        }
        else {
            restMessage = (Map) o;
        }
    }
} 
catch(Exception e) { //better to catch more specific than Exception
    //handle exception
}
finally {
    if(rd != null) {
        rd.close();
    }
    con.disconnect(); //we already checked if null above
}