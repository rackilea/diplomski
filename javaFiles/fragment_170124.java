if(position==0){

              holder.textViewProfession.setGravity(0x11);

              holder.textViewProfession.setOnClickListener(new View.OnClickListener() {

                  @Override
                  public void onClick(View v) {

                      Log.i("row"+getItemId(position)," "+position);


                  }
              });

      }
else{
              holder.textViewProfession.setGravity(0x11);

              holder.textViewProfession.setOnClickListener(null);
}