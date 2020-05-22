PojoCart pojoCart = (PojoCart) getItem(position);
viewHolder.mBtnAdd.setTag(pojoCart);
viewHolder.mBtnMinus.setTag(pojoCart);
if(pojoCart.getQuantity() > 0)
{
   viewHolder.mTvNumber.setText(""+pojoCart.getQuantity());
}
else
{
   viewHolder.mTvNumber.setText(""+0);
}
viewHolder.mBtnAdd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

          PojoCart pojoCart = (PojoCart) v.getTag();
            int mValue = pojoCart.getQuantity();
            mValue++;
            tagHolder.mTvNumber.setText("" + mValue);
            pojoCart.setQuantity(mValue)
            notifyDataSetChanged();
};