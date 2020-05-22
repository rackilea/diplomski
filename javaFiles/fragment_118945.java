if(first_set.getVisibility()!= View.VISIBLE){
                    zoomed_image.setVisibility(View.GONE);
                    first_set.setVisibility(View.VISIBLE);
                }else if(zoomed_image.getVisibility() != View.VISIBLE){
                    first_set.setVisibility(View.GONE);
                    zoomed_image.setVisibility(View.VISIBLE);

                }