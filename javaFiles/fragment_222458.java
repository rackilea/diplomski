Map<Integer, Integer> values = new HashMap<Integer, Integer>();

    int[] definition = {0, 20, 40, 60, 80, 100};
    int[] buckets = new int[definition.length];

    for (int time : values.keySet()) {
        for (int i=definition.length-1; i>=0; i--) {
            if (time >= definition[i]) {
                buckets[i] += values.get(time);
                break;
            }
        }
    }
    for (int i=0; i<definition.length; i++) {
        String period = "";
        if (i == definition.length-1) {
            period = "greater than " + definition[i] + "ms";
        } else {
            period = "between " +
                      (definition[i]+1) +
                      " and " +
                      definition[i+1] + "ms";
        }
        System.out.println(buckets[i] + " came back " + period);
    }