@Async
@TransactionalEventListener
public void onAccountCreated(MailEvent mailEvent) {

    this.mailService.prepareAndSend(mailEvent);
}