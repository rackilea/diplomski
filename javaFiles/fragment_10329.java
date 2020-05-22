@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {

            claim_id = vehicleDetailsArrayList.get(changedPage).getClaimId();

            //Retrieve value of position of last viewed image, before clicking the button
            changedPosition = data.getIntExtra("CHANGED_POSITION", 0);
            Log.i("POSITION 3:"," "+changedPosition);

            if(changedPage > -1 && changedPage < vehicleDetailsArrayList.size()) {
                addUpdateImagePositionInList(claim_id, changedPosition);
            }

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (mViewPager.getAdapter() != null) {
                        mViewPager.getAdapter().notifyDataSetChanged();
                    }
                }
            }, 0);
        }
    }

    public void addUpdateImagePositionInList(int claimId, int position){
        for (int imageLength = 0; imageLength < imagePositionArrayList.size(); imageLength++)
        {
            if (claimId == (imagePositionArrayList.get(imageLength).getClaim_id()))
            {
                imagePositionArrayList.get(imageLength).setImagePosition(position);
                return;
            }
        }
        imagePositionArrayList.add(new ImagePosition(claimId, position));
    }

    public int getChangedImagePosition(int claimId){
        for (int imageLength = 0; imageLength < imagePositionArrayList.size(); imageLength++)
        {
            if (claimId == (imagePositionArrayList.get(imageLength).getClaim_id()))
            {
                Log.i("POSITION123 ","  ::"+ imagePositionArrayList.get(imageLength).getImagePosition() );
                return imagePositionArrayList.get(imageLength).getImagePosition();
            }
        }
        return 0;
    }
`