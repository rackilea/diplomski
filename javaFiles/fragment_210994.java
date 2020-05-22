ActivityManager mgrActivity = (ActivityManager) this.getSystemService( ACTIVITY_SERVICE );

for (RecentTaskInfo run :  mgrActivity.getRecentTasks(Integer.MAX_VALUE, ActivityManager.RECENT_IGNORE_UNAVAILABLE)) {
    if (run.baseIntent.getCategories().contains(Intent.CATEGORY_LAUNCHER)) {
        System.out.println(run.baseIntent.toString());
    }
}