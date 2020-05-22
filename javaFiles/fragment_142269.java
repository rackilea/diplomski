List<Mail> mailListTemp = new ArrayList<>();
while (mailbox.peek() != null) {
    Mail mail = mailbox.take();
    if (!badNews(mail)) {
        mailListTemp.add(mail);
    }
}
for (Mail mail : mailListTemp) {
    mailbox.offer(mail);
}