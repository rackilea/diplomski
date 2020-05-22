Mail firstMail = mailbox.peek();
Mail currentMail = mailbox.pop();
while (true) {
    //a base condition to stop the loop
    Mail tempMail = mailbox.peek();
    if (tempMail == null || tempMail.equals(firstMail)) {
        mailbox.offer(currentMail);
        break;
    }
    //if there's nothing wrong with the current mail, then re add to mailbox
    if (!badNews(currentMail)) {
        mailbox.offer(currentMail);
    }
    currentMail = mailbox.poll();
}