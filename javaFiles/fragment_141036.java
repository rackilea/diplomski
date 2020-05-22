private OnClickListener chavoshipicchangerlistener=new OnClickListener() {
    private final static List<Integer> backgrounds = new ArrayList<Integer>(){
        add(R.drawable.mohsenchavoshione);
        add(R.drawable.mohsenchavoshitwo);
        add(R.drawable.mohsenchavoshithree);
    };

    private int idx = 0;

                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    RelativeLayout relativlayout_ref = (RelativeLayout)findViewById(R.id.RelativeLayout1);

                    idx++;
                    if(idx >= backgrounds.size()){
                        idx = 0;
                    }

                    relativlayout_ref.setBackgroundResource(backgrounds.get(idx));
                }
            };