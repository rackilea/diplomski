if(date.toString().length() > 0)
        {
            //12/31/1986
            cmonth =(Integer.parseInt(date.substring(0,2)));
            cmonth--;
            cday =(Integer.parseInt(date.substring(3,5)));
            cyear =(Integer.parseInt(date.substring(6,10)));
        }