private int current = 1; // Global variable



    final int stock = Integer.parseInt("5");
    final AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Producto " + current + "/" + stock);
    builder.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    });
    builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
        @Override
        public void onDismiss(DialogInterface dialog) {
            if (current < stock) {
                current++;

                // TODO Create your next dialog here.
                builder.setTitle("Producto " + current + "/" + stock);
                builder.show();
            } else {
                // This was the last dialog. Show Toast.
                Toast.makeText(getActivity(), "Se agregaron " + stock + " productos con éxito.", Toast.LENGTH_SHORT).show();
                current = 1;
            }
        }
    });
    builder.show();