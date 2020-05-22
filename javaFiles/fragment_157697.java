private JavaMailSender emailSender;

public void sendSimpleMessage() {

    String[] multipleRecepients = new String[] {"ABC", "xyz"};
    String subject = " This is Email subject";

    String text = "Hi {0} ,\r\n Nice to reach you through email.";
    MessageFormat mf = new MessageFormat(text);


    for (int i = 0 ; i < multipleRecepients.length; i++) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(multipleRecepients[i]);
        message.setSubject(subject); 
        message.setText(mf.format(new Object[] {multipleRecepients[i]}));
        emailSender.send(message);
    }

}