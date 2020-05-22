public void loadAchievements()  {
    mAchievementsClient.load(true).addOnCompleteListener(new OnCompleteListener<AnnotatedData<AchievementBuffer>>() {
        @Override
        public void onComplete(@NonNull Task<AnnotatedData<AchievementBuffer>> task) {
            AchievementBuffer buff = task.getResult().get();
            Log.d("BUFF", "onComplete: ");
            int bufSize = buff.getCount();
            for (int i=0; i < bufSize; i++)  {
                Achievement ach = buff.get(i);
                String id = ach.getAchievementId();
                boolean unlocked = ach.getState() == Achievement.STATE_UNLOCKED;
            }
            buff.release();
        }
    });