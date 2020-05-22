public void saveMessage(Message message)
    {
        String url = "http://localhost:8080/api/save";
        message.setsendTime(new Timestamp(new Date().getTime()));
        this.restTemplate.put(url, new Gson().toJson(message));
        this.messageService.add(new Message(message.getFrom(), message.getMessage()));
    }