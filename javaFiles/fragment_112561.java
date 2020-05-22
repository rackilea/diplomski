ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        PackageManager pm = this.getPackageManager();
        List<String> appList=new ArrayList<>();
        List<ActivityManager.RunningAppProcessInfo> allTasks = am.getRunningAppProcesses();

        for (ActivityManager.RunningAppProcessInfo allTask : allTasks) {
            try {
                CharSequence c = pm.getApplicationLabel(pm.getApplicationInfo(
                        allTask.processName, PackageManager.GET_META_DATA));
                appList.add(c.toString());
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }