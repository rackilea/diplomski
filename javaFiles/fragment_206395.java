final String messageKey;
if (userLoggedIn) {
    messageKey = "logged.in";
} else {
    messageKey = "logged.out";
}
MessageContainer message = new MessageContainer("message", messageKey);
BookmarkablePageLink<Void> link = new BookmarkablePageLink<Void>("link", UserProfilePage.class);
link.add(new Label("username", user.getUsername());
message.add(link);
add(message);