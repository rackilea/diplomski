@Override
    protected void onUserLeaveHint() {
        if (!navigating) {
            Intent intent2 = new Intent();
            intent2.setClass(ActivityA.this, ActivityB.class);
            intent2.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            forceHome(this, intent2);
        }
        super.onUserLeaveHint();
    }

public static void forceHome(Context paramContext, Intent paramIntent) {

        if (paramIntent != null) {
            ((AlarmManager) paramContext.getSystemService(ALARM)).set(1,
                    System.currentTimeMillis(),
                    PendingIntent.getActivity(paramContext, 0, paramIntent, 0));
        }

    }