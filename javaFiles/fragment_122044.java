private void setRv(Context iC)
    {
        RecyclerView.Adapter adapter = new UpSaleInnerAdapter(mPicasso, mInflater, iLink -> mListener.onButtonClick(iLink));

        mRv.setLayoutManager(new SmoothLayoutManager(iC, LinearLayoutManager.HORIZONTAL, false).setSpeedOfSmooth(SmoothLayoutManager.X_200));
        mRv.setAdapter(adapter);

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(mRv);
    }