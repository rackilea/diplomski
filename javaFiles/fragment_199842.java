@Email(messageResId = R.string.invalid_email)
@BindView(R.id.et_mail)
EditText etMail;


From source code of saripar

@ValidateUsing(EmailRule.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Email {
    boolean allowLocal()    
default false;

    int sequence()          default -1;
    int messageResId()      default -1;
    String message()        default "Invalid email";
}