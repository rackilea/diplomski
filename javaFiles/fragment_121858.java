@Produces @MessageBundle
public ResourceBundle getBundle() {
    if (bundle == null) {
        bundle = ResourceBundle.getBundle("com.example.msgs");
    }
    return bundle;
}