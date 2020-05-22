Map<Week, String> map = new EnumMap<Week, String>(Week.class);

        map.put(Week.WED, "Wednesday");
        map.put(Week.SUN, "Sunday");
        map.put(Week.MON, "Monday");
        map.put(Week.THU, "Thursday");
        map.put(Week.SAT, "Saturday");
        map.put(Week.FRI, "Friday");
        map.put(Week.TUE, "Tuesday");


        for(Week week : map.keySet()){
            System.out.println(week + " -- " +map.get(week));
        }