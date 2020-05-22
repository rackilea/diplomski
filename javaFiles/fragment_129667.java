public class RestartAlarmsReceiver extends BroadcastReceiver {
private String TAG = "halo";

@Override
public void onReceive(Context context, Intent intent) {

    if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
        Log.e("starting", "starting JobScheduler");
        schedule(context);
    } else {
        Log.e(TAG, "Received unexpected intent " + intent.toString());
    }
}

private void schedule(Context context) {
    // say when Job has to be executed
    ComponentName componentName = new ComponentName(context, JobServiceC.class);
    JobInfo info = new JobInfo.Builder(145, componentName)
            .setOverrideDeadline(0)
            .setPersisted(true)                                     // keeps job alive after reboot -> need permission
            .build();

    JobScheduler scheduler = (JobScheduler) context.getSystemService(JOB_SCHEDULER_SERVICE);
    int resultCode = scheduler.schedule(info);

    if (resultCode == JobScheduler.RESULT_SUCCESS) {
        Log.e("TAG", "Job scheduled");
    } else {
        Log.e("TAG", "Job not scheduled");
    }
}

private void cancel(Context context) {
    JobScheduler scheduler = (JobScheduler) context.getSystemService(JOB_SCHEDULER_SERVICE);
    scheduler.cancel(145);
    Log.e("TAG", "JobCancelled");
}