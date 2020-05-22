class MyAdapter extends ArrayAdapter{
    SuccessResponse successResponse;

    public MyAdapter(Context context, int resource) {
        super(context, resource);
    }

    public interface SuccessResponse{
        void onSuccess();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //ur views
        linearLayout.setOnClickListener(new View.OnClickListener{
            @Override
            public void onClick (View view){
                if(successResponse!=null)
                    successResponse.onSuccess();
            }
        })
    }
}