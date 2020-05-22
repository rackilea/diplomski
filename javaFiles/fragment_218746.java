holder.mDeleteView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //show an alert to user to confirm before remving the item from cart
                    AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                    //alertDialog.setTitle("Alert");
                    alertDialog.setMessage(getString(R.string.alert_remove_item_from_cart_text));
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, getString(android.R.string.ok),
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    mValues.remove(holder.mItem);
                                    if(null != mItemModifiedListener)mItemModifiedListener.itemDeleted(holder.mItem);
                                    notifyItemRemoved(position);
                                    //notifyDataSetChanged();
                                }
                            });
                    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, getString(android.R.string.no),
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            });