@Override
public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
    if (cursor == null || cursor.getCount() < 1) {
        return;
    }

    if (cursor.moveToFirst()) {
        int nameColumnIndex = cursor.getColumnIndex(ProductContract.ProductEntry.COLUMN_PRODUCT_NAME);
        int priceColumnIndex = cursor.getColumnIndex(ProductContract.ProductEntry.COLUMN_PRODUCT_PRICE);
        int quantityColumnIndex = cursor.getColumnIndex(ProductContract.ProductEntry.COLUMN_PRODUCT_QUANTITY);
        int supplierColumnIndex = cursor.getColumnIndex(ProductContract.ProductEntry.COLUMN_PRODUCT_SUPPLIER);
        int mailColumnIndex = cursor.getColumnIndex(ProductContract.ProductEntry.COLUMN_PRODUCT_SUPPLIER_MAIL);
        int pictureColumnIndex = cursor.getColumnIndex(ProductContract.ProductEntry.COLUMN_PRODUCT_PICTURE);

        String name = cursor.getString(nameColumnIndex);
        String price = cursor.getString(priceColumnIndex);
        int quantity = cursor.getInt(quantityColumnIndex);
        String supplier = cursor.getString(supplierColumnIndex);
        String mail = cursor.getString(mailColumnIndex);
        stringUri = cursor.getString(pictureColumnIndex);

        mPictureUri = Uri.parse(stringUri);


        mNameEditText.setText(name);
        mPriceEditText.setText(price);
        mQuantityEditText.setText(String.valueOf(quantity));
        mSupplierEditText.setText(supplier);
        mMailEditText.setText(mail);
    }

    ViewTreeObserver viewTreeObserver = mProductImageView.getViewTreeObserver();
    viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                mProductImageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if(mPictureUri !=null) {
                    mProductImageView.setImageBitmap(getBitmapFromUri(mPictureUri, mContext, mProductImageView));
                }
            }
        }
    });
}