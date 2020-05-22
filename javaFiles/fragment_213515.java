public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_help, null);
     sendEmail = (Button)v.findViewById(R.id.SendBtn);
     msg = (EditText)v.findViewById(R.id.msgTxt);

      sendEmail.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v){
           String message = msg.getText().toString();
            sendEmail(message);
        }

    });
        return v;
}