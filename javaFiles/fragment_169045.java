public static Object[][] getstation1(){
        Object[][] data = null;
        try {
            JSONObject json = new JSONObject(readUrl("http://netzwerk.wetter.com/api/stationdata/14091/2/"));
            System.out.println("Fetching "+"http://netzwerk.wetter.com/api/stationdata/14091/2/");
            String[] times = json.getNames(json);
            Arrays.sort(times);
            data = new Object[times.length][8];
            for (int i = 0; i < times.length; i++){
                Date temp = new Date((long)Integer.parseInt(times[i])*1000);
                data[i][0] = temp;
                if (json.getJSONObject(times[i]).isNull("hu")){
                    data[i][1] = 0;
                } else {
                    data[i][1] = json.getJSONObject(times[i]).getDouble("hu");
                }   
                if (json.getJSONObject(times[i]).isNull("te")){
                    data[i][2] = 0;
                } else {
                    data[i][2] = json.getJSONObject(times[i]).getDouble("te");
                }   
                if (json.getJSONObject(times[i]).isNull("dp")){
                    data[i][3] = 0;
                } else {
                    data[i][3] = json.getJSONObject(times[i]).getDouble("dp");
                }   
                if (json.getJSONObject(times[i]).isNull("pr")){
                    data[i][4] = 0;
                } else {
                    data[i][4] = json.getJSONObject(times[i]).getDouble("pr");
                }   
                if (json.getJSONObject(times[i]).isNull("pa")){
                    data[i][5] = 0;
                } else {
                    data[i][5] = json.getJSONObject(times[i]).getDouble("pa");
                }   
                if (json.getJSONObject(times[i]).isNull("ws")){
                    data[i][6] = 0;
                } else {
                    data[i][6] = json.getJSONObject(times[i]).getDouble("ws");
                }   
                if (json.getJSONObject(times[i]).isNull("wd")){
                    data[i][7] = 0;
                } else {
                    data[i][7] = json.getJSONObject(times[i]).getDouble("wd");
                }                   
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }       
        return data;
    }