public void Start(LinkedList<String> command) {
        int xtime = 0;
        boolean goodTime = false, goodTimeFrame = false;

        String time = command.get(1);
        String timeframe = command.get(2);

        try {
            xtime = Integer.parseInt(time);
            if(xtime<0) { System.out.println("time cannot be less than 0..."); }
            else if(xtime>=0) { goodTime = true; }
        } catch(Exception e){ System.out.println("invalid input..."); }

        try {
            switch(timeframe.toLowerCase()) {
                case "secs":
                    goodTimeFrame = true;
                    break;
                case "mins":
                    xtime = xtime*60;
                    goodTimeFrame = true;
                    break;
                case "hrs":
                    xtime = xtime*3600;
                    goodTimeFrame = true;
                    break;
                default:
                    System.out.println("invalid timeframe, use: secs, mins, or hrs...");
                    break;
            }
        } catch(Exception e){ System.out.println("cannot convert to valid time..."); }

        if(goodTime && goodTimeFrame) {
            try {
                Runtime.getRuntime().exec("cmd /c shutdown -s -t "+xtime);
            } catch(Exception e){ System.out.println("error ordering shutdown command..."); }
        }
        else { System.out.println("syntex example : shutdown time timeframe"
                                                 + "\nshutdown 10 mins"); }
    }