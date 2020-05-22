String line = "[2013-12-02 10:13:47,125]: R=\"RUNNING.JOB.Q\", REQUEST_UUID=\"7e1ed77c-afe3-992d-bc86-824ce73f4b6b\", SRC_OBJ=\"ScheduledEvent.14060204\", DB2.QUERY_CT=22, DB2.UPDATE_CT=1, DB2.SVR_MS=52, DB2.IO_MS=66, DB2.DRV_MS=74";
            String valueOf = "DB2.QUERY_CT";
            String delimiter = ",";
            String value = null;
            if (line.indexOf(valueOf) > -1){
                line =  line.substring(line.indexOf(valueOf) + valueOf.length() + 1);
                value  = line.substring(0, line.indexOf(delimiter));
                value = value.trim();
            }

            System.out.println("Value  " + value);