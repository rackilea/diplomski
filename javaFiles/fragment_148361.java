@Override
protected void onCreate(Bundle savedInstanceState) {
    ...
    logoIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cnt >= 2) {
                    adminLinear.setVisibility(View.VISIBLE);
                    adminLinear.setEnabled(true);
                } else {
                    cnt++;
                }
            }
        });
}