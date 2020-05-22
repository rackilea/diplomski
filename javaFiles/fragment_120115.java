Map<Long, List<Message>> userGroup = new HashMap<>();
        for (Message message : messages) {
            List<Message> userMessages = userGroup.get(message.author.getId());
            if (userMessages == null) {
                userMessages = new ArrayList<>();
                userGroup.put(message.author.getId(), userMessages);
            }
            userMessages.add(message);
        }
        for (Entry<Long, List<Message>> entry : userGroup.entrySet()) {
            for (Message message : entry.getValue()) {
                System.out.println(entry.getKey() + " : " + message.date);
            }
        }