new AlertDialog.Builder(this).setTitle("Delete").setMessage("Review").setPositiveButton(R.string.positive_delete, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(final DialogInterface dialog, final int id) {
          // use position here.
        }
      }).setNegativeButton(R.string.negative_reask, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(final DialogInterface dialog, final int id) {
          dialog.dismiss();
        }
      }).create().show();