class ViewDashboard extends RecyclerView.ViewHolder {
    public int position


 public void onBindViewHolder(ViewDashboard holder, int position) {
     holder.position = position
 }

 public void liked(LikeButton likeButton) {
     QuestionData questionHolder = data.get(position);