Queue<Message> buffer = new PriorityQueue<>();
    buffer.add(new Message(Status.NORMAL));
    buffer.add(new Message(Status.EMERGENCY));
    buffer.add(new Message(Status.SPECIAL_INTEREST));
    buffer.add(new Message(Status.BREAKING_NEWS));
    while (!buffer.isEmpty()) {
        System.out.println(buffer.poll().status.value());
    }