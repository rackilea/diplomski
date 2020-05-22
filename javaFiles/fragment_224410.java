case ORDER_DIALOG:
    AlertDialog.Builder orderBuilder = new AlertDialog.Builder(this);
    orderBuilder.setTitle("Order");
    orderBuilder.setItems(order, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            String orderS;
            if (order[which].equalsIgnoreCase("Ascending"))
                orderS = "ASC";
            else
                orderS = "DESC";

            bundle.putString("order", orderS);
            dialog.dismiss();
            showDialog(COLUMNS_DIALOG); // <-- NEW!!!
        }
    });
    dialog = orderBuilder.create();
    break;