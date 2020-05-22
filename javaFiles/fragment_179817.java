public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.inflate(LayoutInflater.from(this),R.layout.activity_main,null,false);
        Person lUser = new Person();
        Person.PickedDate lBirthday = new Person.PickedDate();
        lBirthday.getDay().set(3);
        lBirthday.getMonth().set(4);
        lBirthday.getYear().set(5);
        lUser.setBirthday(lBirthday);
        binding.setUser(lUser);
        setContentView(binding.getRoot());
    }
}