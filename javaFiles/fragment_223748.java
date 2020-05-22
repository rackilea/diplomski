Map<String, Integer> maths = new HashMap<String, Integer>();
        maths.put("Nirmala", 70);
        maths.put("Subaksha", 80);
        Map<String, Integer> english = new HashMap<String, Integer>();
        english.put("Nirmala", 75);
        english.put("Subaksha", 60);

        System.out.println(english.entrySet());
        System.out.println(maths.entrySet());

        Map<String, Integer> top = new HashMap<String, Integer>();
        for (Map.Entry<String, Integer> math: maths.entrySet()){    
            System.out.println( "Teacher : " +math.getKey() + " Max Feedback :" + Math.max(math.getValue(), english.get(math.getKey())));
          }