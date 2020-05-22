if (mCurrent.getQuantity() < 1.0) {
            pieces = productViewHolder.context.getText(R.string.out_of_stock).toString();
            productViewHolder.itemQuantity.setTextColor(Color.RED);
        } else if (mCurrent.getQuantity() <= mCurrent.getLowQuantityAlertValue()) {
            pieces = mCurrent.getQuantity() + " " + mCurrent.getAmountType() + " " + productViewHolder.context.getText(R.string.pieces);
            productViewHolder.itemQuantity.setTextColor(context.getResources().getColor(R.color.orange));
        } else {
            productViewHolder.itemQuantity.setTextColor(Color.RED) // any default color
        }