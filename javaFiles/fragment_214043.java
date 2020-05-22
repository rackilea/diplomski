interface ICompletedMailer { // Mailer should also implement this

}

interface IBodyBuilder {
    ICompletedMailer body(String body);
}