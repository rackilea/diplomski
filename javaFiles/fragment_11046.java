if (!disableViews) {
    holder.mView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            if (mListener != null) {
                mListener.onClickBoard(mValues.get(i));
            }else{
                ((MainActivity)mContext).onClickBoard(mValues.get(i).getAreaId(), mValues.get(i).getName());
            }
            disableViews = true;
            notifyDataSetChanged();
        }
    });
} else {
    holder.mView.setOnClickListener(null);
}