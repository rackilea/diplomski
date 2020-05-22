if(!encls.isEmpty()){
        holder.imageUrl = encls.get(0).getUrl();
    } else {
        holder.imageUrl = null;
    }

    if (!encls.isEmpty() && holder.imageUrl != null && !holder.imageUrl.equals("null")) {
        holder.setImage(holder.imageUrl);
    } else {
        holder.itemImg.setImageResource(R.mipmap.news_icon);
    }