public class FooActivity extends AppCompatActivity {
        @Inject
        public CoreRepository repo;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            CoreComponent coreComponent = MyApplication.getCoreComponent(this);
            DaggerActivityComponent.builder()
                .coreComponent(coreComponent)
                .build()
                .inject(this);
        }
    }
}