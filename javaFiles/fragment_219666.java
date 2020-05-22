public interface FileNameProvider {
    public void onNewFileName(String filename);
}

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.mylayout1);
    findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (getParent() instanceof FileNameProvider) {
                ((FileNameProvider) getParent()).onNewFileName("some file name");
            }
        }
    });
}