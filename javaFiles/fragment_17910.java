@Override
    public void onBindViewHolder(adapter_zakeran_any.ItemViewHolder holder, int position) {

        item = itemlist.get(position);
        nameeee = item.getInfo();


        holder.namemadahi.setText(item.getInfo());
        holder.madah.setText(item.getSpeaker_name());
        holder.link.setText(item.getFile());
        final String ml = (String) holder.link.getText();


        namemadahi_h = (String) holder.namemadahi.getText();
        namemadah_h = item.getSpeaker_name();

     // Here you apply the animation when the view is bound
        setAnimation(holder.itemView, position);

    }

 /**
     * Here is the key method to apply the animation
     */
    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.item_animation_fall_down);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }