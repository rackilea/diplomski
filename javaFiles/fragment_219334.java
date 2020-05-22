mFav.addValueEventListener(new ValueEventListener() {
               @Override
               public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                   if (dataSnapshot.child(puid).hasChild(kk)){
                       Holder.mFavouritesBlack.setVisibility(View.GONE);
                       Holder.mFavouritesYellow.setVisibility(View.VISIBLE);

                   }else{
                       Holder.mFavouritesBlack.setVisibility(View.VISIBLE);
                       Holder.mFavouritesYellow.setVisibility(View.GONE);
                   }
               }

               @Override
               public void onCancelled(@NonNull DatabaseError databaseError) {

               }
           });
 Holder.mFavouritesBlack.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {

                    mFav.child(puid).child(kk).child("fav_status").setValue("Added as fav").addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getContext(), "Added to Fav", Toast.LENGTH_SHORT).show();

                            if (!itemStateArray.get(adapterPosition, false))
                                Holder.mFavouritesBlack.setVisibility(View.GONE);
                            Holder.mFavouritesYellow.setVisibility(View.VISIBLE);


                        }
                    });
                    return true;
                }
            });
            Holder.mFavouritesYellow.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    mFav.child(puid).child(kk).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getContext(), "Removed from Fav", Toast.LENGTH_SHORT).show();
                            if (itemStateArray.get(adapterPosition, false))
                                Holder.mFavouritesBlack.setVisibility(View.VISIBLE);
                            Holder.mFavouritesYellow.setVisibility(View.GONE);


                        }
                    });
                    return true;
                }
            });