public MyResourceCustomAdaper(Activity mActivity,Context context,
                         ArrayList<HashMap<String, String>> data) {
        this.context = context;
        this.data = data;
        this.getMatchingJobsArray=(GetMatchingJobsArray)mActivity;
    }