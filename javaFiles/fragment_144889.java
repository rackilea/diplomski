public void setMessages(List<Message> newMessages) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
            Collections.sort(newMessages);
        Iterator<Message> it = messages.iterator();
        while (it.hasNext()) {
            Message mess = it.next();
            if (!newMessages.contains(mess)) {
                it.remove();
                this.fireTableDataChanged();
            }
        }
        for (Message message : newMessages)
            if (message.isOrderStatusMessage())
                if (!messages.contains(message)) {
                    addMessage(message);
                }
        this.fireTableDataChanged();
    }
  )};
}