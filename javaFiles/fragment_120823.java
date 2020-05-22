public void onStatus(twitter4j.Status status) {
    System.out.println("onStatus @" + status.getUser().getScreenName() + " - " + status.getText() + " - " + status.getCreatedAt());

    obj.setMsg(status.getText());
    obj.setDateTime(String.valueOf(status.getCreatedAt()));
    obj.setId((int) status.getId());
    prod(obj);
}