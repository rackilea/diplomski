public void setAvatarUrl(String avatarUrl) {
    try {
        // This will actually set the AVATAR value on the record itself!
        super.setAvatar(avatarUrl.getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
        System.err.println("failed to getBytes() on avatar");
    }
}