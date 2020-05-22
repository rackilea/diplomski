final Intent activityIntent = new Intent(
                activity.getApplicationContext(), CurrentActivity.class);
        activityIntent .putExtra("ID",
                item.ID);
        activityIntent .putExtra("NAME",
                item.name);
        activity.startActivity(activityIntent);