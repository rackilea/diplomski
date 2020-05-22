override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
    holder?.textTitle?.text = userList[position].title
    holder?.textPrice?.text = userList[position].price
    String url = userList[position].url
    Picasso.with(context).load(url).placeHolder(R.drawable.image).into(photoView);
    //holder?.photoView?.setImageResource(userList[position].photoId)
}