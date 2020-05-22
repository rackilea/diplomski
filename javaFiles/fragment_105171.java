@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.fragment_main, container,
            false);
    Button login = (Button) rootView.findViewById(R.id.loginButton);
    login.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {

            Intent intent = new Intent(MainActivity.this,
                    LoginActivity.class);
            startActivity(intent);
        }
    });

    return rootView;
}