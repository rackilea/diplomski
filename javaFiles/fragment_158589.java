public class YourActivity extends AppCompatActivity{
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getContentView());

    // you can use checkEmailValidation like 
    YourClassName.checkEmailValidation(...)

  }

}