public void setAvatarUrl(String avatarUrl) {
    try {
        this.avatar = avatarUrl.getBytes("UTF-8");
    } catch (UnsupportedEncodingException e) {
        System.err.println("failed to getBytes() on avatar");
    }
}