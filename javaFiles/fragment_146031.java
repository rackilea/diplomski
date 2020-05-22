if(model.getApproval().equals("Unchecked")) {
        // Menu Popup
        holder.rlPopUpMenu.setVisibility(View.VISIBLE);
        holder.rlPopUpMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(view.getContext(), view);
                popup.getMenuInflater().inflate(R.menu.order_item_popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        if(menuItem.getItemId() == R.id.action_accept) {
                            Toast.makeText(activity, "You Click Accept", Toast.LENGTH_SHORT).show();
                        }


                        if(menuItem.getItemId() == R.id.action_denied) {
                            Toast.makeText(activity, "You Click Denied", Toast.LENGTH_SHORT).show();
                        }

                        return true;
                    }
                });
                popup.show();
            }
        });


    } else if(model.getApproval().equals("Accept")) {
        holder.rlPopUpMenu.setVisibility(View.GONE);
        holder.tvApproval.setTextColor(Color.parseColor("#32FF84"));
    } else if(model.getApproval().equals("Denied")) {
        holder.rlPopUpMenu.setVisibility(View.GONE);
        holder.tvApproval.setTextColor(Color.parseColor("#1F9999"));
    }