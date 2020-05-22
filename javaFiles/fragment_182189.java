public Activity c;
        public Dialog d;
        public Button close;
        public ImageView pImage;
        public TextView title;
        public TextView utensils;
        public TextView preparation;

        // variables those will handle values. i did not implement it for image you can do same for that also.
        private String titleValue;
        private String utensilsValue;
        private String preparationValue;

        public ProductDialog(Activity a) {
            super(a);
            // TODO Auto-generated constructor stub 
            this.c = a;
        } 

        @Override 
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.product_dialog);
            close = (Button) findViewById(R.id.popClose);
            close.setOnClickListener(this);
            pImage = (ImageView) findViewById(R.id.popImg);
            title = (TextView) findViewById(R.id.popTitle);
            utensils = (TextView) findViewById(R.id.popUtensili);
            preparation = (TextView) findViewById(R.id.popPreparazione);
            title.setText(titleValue);
            utensils.setText(utensilsValue);
            preparation.setText(preparationValue);
        } 

        @Override 
        public void onClick(View v) {
            switch (v.getId()) {
            case R.id.popClose:
                dismiss();
                break; 
            default: 
                break; 
            } 
            dismiss();
        } 

        public void setImage(String urlImg) {
            Picasso.with(getContext())
              .load(urlImg)
              .placeholder(R.drawable.placeholder)
              //.transform(new RoundedTransformation(10, 0)) 
              .fit().centerCrop() 
              .into(pImage);
        } 

    // Created  getter and setter to get get value form mainActivity. 
        public void setTitle(String txtTitle) {
            titleValue = (txtTitle);
        } 
        public void setUtensils(String txtUtensils) {
            utensilsValue = (txtUtensils);
        } 
        public void setPreparation(String txtPreparation) {
            preparationValue = (txtPreparation);
        } 
    }