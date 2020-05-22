// if no url is found from server
if(url == null){
  ((ObjectViewHolder) holder).userPostImageWrapper.setVisibility(View.GONE);
  ((ObjectViewHolder) holder).userPostYoutubeImageWrapper.setVisibility(View.GONE);

} else {
  // Some url has found 
  ((ObjectViewHolder) holder).userPostImageWrapper.setVisibility(View.VISIBLE);
  ((ObjectViewHolder) holder).userPostYoutubeImageWrapper.setVisibility(View.VISIBLE);
}