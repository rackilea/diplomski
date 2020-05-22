public class User {

    private String mUserId;
    private Uri mImageUrl;

    public User(String userId, String imageUrl) {
        mUserId = userId;
        mImageUrl = Uri.parse(imageUrl);
    }

    public String getUserId() {
        return mUserId;
    }

    public Uri getImageUrl() {
        return mImageUrl;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof User) {
            User user = (User) other;
            return mUserId.equals(user.getUserId()) && mImageUrl.equals(user.getImageUrl());
        } else {
            return false;
        }
    }

}