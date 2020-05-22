public CustomAdapter(Contacts activity,ArrayList<String>n, ArrayList<String>nums, ArrayList<String>e){

    mActivity = activity;
    phoneNumbers = nums;
    names = n;
    emails = e;
    inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

}

@Override
public void onClick(View v) {
    switch (v.getId()){
        case R.id.customRowContactNumber:{
            Intent i = new Intent(Intent.ACTION_DIAL);
            mActivity.startActivity(i);//THIS IS THE ISSUE I THINK
            break;
        }
    }

}