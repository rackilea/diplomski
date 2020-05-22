list = new ArrayList<AppProcessInfo>();
        ApplicationInfo appInfo = null;
        AppProcessInfo abAppProcessInfo = null;

        List<ActivityManager.RunningAppProcessInfo> appProcessList = activityManager
                .getRunningAppProcesses();
  //      publishProgress(0, appProcessList.size());
        List<AndroidAppProcess> processes = AndroidProcesses.getRunningAppProcesses();

        for (AndroidAppProcess appProcessInfo : processes) {

            String processName = appProcessInfo.name;

            Stat stat = null;
            try {
                stat = appProcessInfo.stat();
            } catch (IOException e) {
                e.printStackTrace();
            }

            abAppProcessInfo = new AppProcessInfo(
                    appProcessInfo.name, stat.getPid(),
                    appProcessInfo.uid);
            try {
                appInfo = appProcessInfo.getPackageInfo(mContext, 0).applicationInfo;
.........................