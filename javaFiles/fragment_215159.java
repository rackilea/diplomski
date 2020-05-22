@Async
@TransactionalEventListener(fallbackExecution = true)
public void onAccountCreated(MailEvent mailEvent) {

    this.mailService.prepareAndSend(mailEvent);
}