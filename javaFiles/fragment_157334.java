public List<Messages> filterMessagesByData(Calendar filterDate, ArrayList<Messages> messagesList) {
    return messagesList.stream().filter(message -> {
        Calendar msgDate = Calendar.getInstance();
        try {
            msgDate.setTime(new SimpleDateFormat("dd/MM/yy").parse(message.getDate()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return msgDate.compareTo(filterDate) >= 0;
    }).limit(MAX_MESSAGES_NUM).collect(Collectors.toList());
}