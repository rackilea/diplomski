private LiveData<UserProfile> userProfile;

@Override
public void onChanged(@Nullable UserProfile sections) {
    AsyncTask.execute(new Runnable() {
        @Override
        public void run() {
            // Option 1: use method parameter
            mDb.userProfileDao().update(sections);

            // Option 2: get the value
            mDb.userProfileDao().update(userProfile.getValue());
        }
    });
}