if (from_user != null && from_user.equals(current_user_id)) {
    holder.messageText.setTextColor(Color.BLACK);
    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) holder.messageText.getLayoutParams();
    //remove rules
    params.removeRule(RelativeLayout.ALIGN_PARENT_LEFT);

    params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
    holder.messageText.setLayoutParams(params);

            if (Seen==1){
                holder.messageText.setBackgroundResource(R.drawable.text_background2);
            }else{
                holder.messageText.setBackgroundResource(R.drawable.text_background1);
            }

}else {
        holder.messageText.setBackgroundResource(R.drawable.text_background2);
        holder.messageText.setTextColor(Color.BLACK);

    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) holder.messageText.getLayoutParams();
    //remove rules
    params.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT);

    params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
    holder.messageText.setLayoutParams(params);
    }

    holder.messageText.setText(messages.getMessage());
}