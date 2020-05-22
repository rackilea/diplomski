if (holder.txtPosition.getText().equals("Ausgeschieden")) {
    holder.txtPosition.setTextColor(0xFFFF0000);
} else if (holder.txtPosition.getText().equals("User-Voting")) {
    holder.txtPosition.setTextColor(0xFF00CC00);
} else {
    holder.txtPosition.setTextColor(R.color.your_default);
}