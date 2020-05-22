int zander = 1;
button01.setOnClickListener(new View.OnClickListener() {
        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        public void onClick(View v) {
            if (zander == 1) {
                 ((Button) android.findViewById(R.id.one)).setBackground(getResources().getDrawable(R.drawable.border_inner_green));
                 zander = 2;
                 System.out.println(zander+"green");
            } else {

                 ((Button) android.findViewById(R.id.two)).setBackground(getResources().getDrawable(R.drawable.border_inner_red));
                zander = 1;
                System.out.println(zander+"red");
            }
    });