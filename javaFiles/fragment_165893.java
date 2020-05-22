adapter.setViewBinder(new SimpleAdapter.ViewBinder() {
                    @Override
                    public boolean setViewValue(View view, Object data,String textRepresentation) 
                    {
                        if((view instanceof ImageView) & (data instanceof Bitmap)) 
                        {
                            ImageView iv = (ImageView) view;
                            Bitmap bm = (Bitmap) data;
                            iv.setImageBitmap(bm);
                            return true;
                        }
                        return false;
                    }
                });