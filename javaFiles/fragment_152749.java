class ViewHolder extends RecyclerView.ViewHolder{

    public TextView discountedvalue;

    public CardView cardview;

    public ViewHolder(View itemView) {

        super(itemView);
        discountedvalue = (TextView) itemView.findViewById(R.id.DiscountValue);
        cardview = (CardView) itemView.findViewById(R.id.cardview);
        discountedvalue.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {

                    if(editable.toString().equals("0 % off")){

                        cardview.setVisibility(View.GONE);

                    }else{

                        cardview.setVisibility(View.VISIBLE);

                    }


                }
            });

    }
}