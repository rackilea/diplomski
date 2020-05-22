if (MessageConfirmed.equals("Yes")) {
        btn_confirm.setText("Confirmed");
        btn_confirm.setBackground(ContextCompat.getDrawable(context, 
R.drawable.confirm_button_blue));
        btn_confirm.setEnabled(false);

    } else {
        btn_confirm.setText("Confirm");
        btn_confirm.setBackground(ContextCompat.getDrawable(context, 
R.drawable.confirm_button_green));
        btn_confirm.setEnabled(true);

}