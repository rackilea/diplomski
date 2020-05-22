@JmsListener(destination = "my_topic_new", containerFactory = "myFactory", subscription = "foo")
public void receiveTopic(String email) {
    System.out.println("list_1:" + email);
}

@JmsListener(destination = "my_topic_new", containerFactory = "myFactory", subscription = "bar")
public void receiveTopicDup(String email) {
    System.out.println("list_2:" + email);
}