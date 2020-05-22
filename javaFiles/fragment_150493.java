holder.getImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCallback!=null){
                    mCallback.onImageClicked(imageFile.getAbsolutePath());
                }
            }
        });