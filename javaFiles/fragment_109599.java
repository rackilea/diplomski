public String[] concatAll(String[] jobsA, String[] jobsB, String[] jobsC, String[] jobsD) 
    {
        return generalConcatAll (jobsA, jobsB, jobsC, jobsD);
    }

    public String[] generalConcatAll(String[]... jobs) {
        int len = 0;
        for (final String[] job : jobs) {
            len += job.length;
        }

        final String[] result = new String[len];

        int currentPos = 0;
        for (final String[] job : jobs) {
            System.arraycopy(job, 0, result, currentPos, job.length);
            currentPos += job.length;
        }

        return result;
    }