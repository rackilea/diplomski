public class ProfileViewModel {

    private User mUser;
    private IProfiler mProfiler;

    public ProfileViewModel(IProfiler profiler){
        mProfiler = profiler;
    }

    public void onSaveClicked(User user) {
        try {
            String nameTest = user.get_name();
            String surnameTest = user.get_surname();

            new AsyncTaskPost(mProfiler).execute(new URL("http://www.Trackme.com"));
        }
        catch (Exception ex) {

        }
    }
}