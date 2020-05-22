public static String getBeacon(int index, String value)
    {
        String result = "";
        switch(value){
            Beacon becon = Liste.get(index);
            case "UUID":    
                result = becon!=null?becon.getUUID():"";
                break;
            case "Major":   
                result = becon!=null?becon.getMajor():"";
                break;
            case "Minor":   
                result = becon!=null?becon.getMinor():"";
                break;
            case "RSSI": 
                resultTemp = becon!=null?becon.getRSSI():0;
                result = String.valueOf(resultTemp);
                break;
        }
        return result==null?"":result;
    }