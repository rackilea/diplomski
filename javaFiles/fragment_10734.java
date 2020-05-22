@Bean
@Qualifier("basicPhone")
public Phone basic() {
    Phone phone = new BasicPhone();
    return phone;

}