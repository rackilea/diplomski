eg.

public class SomeClass{

ParsingCompleteHandler  parsingCompleteHandler;


static class ParsingCompleteHandler extends Handler {
    private final WeakReference<BackupActivity> mTargetActivity;
    ParsingCompleteHandler(BackupActivity targetActivity) {
        mTargetActivity = new WeakReference<BackupActivity>(targetActivity);
    }

    @Override
    public void handleMessage(Message msg) {
        BackupActivity targetActivity = mTargetActivity.get();
        targetActivity.updateDialog();
    }
};