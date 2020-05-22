public abstract class BaseDialogListener implements DialogListener {
    @Override
    public void onFacebookError(FacebookError e) {
        e.printStackTrace();
    }
    @Override
    public void onError(DialogError e) {
        e.printStackTrace();
    }
    @Override
    public void onCancel() {
    }
}

public class PostDialogListener extends BaseDialogListener {
    @Override
    public void onComplete(Bundle values) {
        final String postId = values.getString("post_id");
        if (postId != null) {
            showToast("Message posted on the wall.");
        } else {
            showToast("No message posted on the wall.");
        }
    }
}