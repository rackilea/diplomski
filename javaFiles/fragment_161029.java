public String getCheckinDate() {

    if(get("checkinDate")==null)
            return null;
        else 
            return get("checkinDate").toString();


            }