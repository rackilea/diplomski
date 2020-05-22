@Bean
public JavaMailSender javaMailSender() {
    JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
    // set properties on javaMailSender (user, password, etc)
    return javaMailSender;
}