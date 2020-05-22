private DataPoint[] getDataPoint() {
        if (olddb.check()) {
            List<oldDetails> details = olddb.getDetails();
            long c = olddb.QueryNumEntries();
            int count = (int) c;
            Log.d("Count", "equals: " + count);

        double[] arrayWeight = new double[count];
        int[] arrayId = new int[count];
        for (oldDetails cn : details) { //Adding weights and id of all time to an array.
            double num = cn.getWeight();
            int id = cn.getId();
            Log.d("num", "equals: " + num);
            Log.d("id", "equals: " + id);
            for (int i = count; i < 0; i--) {
                arrayWeight[i] = num;
                arrayId[i] = id;
            }
        }
        DataPoint[] dp = new DataPoint[count];
        for (int i = 0; i < arrayId.length; i++) {
            for (int j = 0; j < arrayWeight.length; j++) {
                dp[i] = new DataPoint(arrayId[i], arrayWeight[j]);
                Log.d("ArrayWeight", "equals: " + arrayWeight[j]);
                Log.d("ArrayId", "equals: " + arrayId[i]);
            }
        }

        return dp;
    }

        DataPoint[] dp = new DataPoint[]{
                new DataPoint(0, 0)
        };
        return dp;
    }