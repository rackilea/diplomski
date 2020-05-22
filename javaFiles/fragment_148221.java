LayoutInflater inflater = (LayoutInflater)EEActionListDetail.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    Display display = getWindowManager().getDefaultDisplay();

    int width = display.getWidth()/2;
    int height = display.getHeight()/2;

    View pop = inflater.inflate(R.layout.popupemail,null,false);
    pop.measure(View.MeasureSpec.UNSPECIFIED,View.MeasureSpec.UNSPECIFIED);
    height = pop.getMeasuredHeight();
    width = pop.getMeasuredWidth()+200;
    pu = new PopupWindow(pop,width,height,true);
    pu.showAtLocation(findViewById(R.id.ll3),Gravity.CENTER,1,1);

    Button brnSend = (Button)pu.getContentView().findViewById(R.id.btnSend);
    Button close = (Button)pu.getContentView().findViewById(R.id.close);

    Subject = (EditText)pu.getContentView().findViewById(R.id.subject);
    Message = (EditText)pu.getContentView().findViewById(R.id.message);

    close.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            pu.dismiss();

        }
    });
    brnSend.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            for(int j=0;j<EmailArray.size();j++){
                String EmailSent = EmailArray.get(j);
                SendEmailALL(EmailSent);
            }
        }
    });