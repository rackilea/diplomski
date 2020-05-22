DisplayMetrics displayMetrics = new DisplayMetrics();
        mContext.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        Log.e("width",width+""+height);


        //--------calculate width and height
        int final_width;
        double final_height;
        final_width  = width - 40;
        final_height = ((final_width) * (0.75));
        int height_final = (int) (final_height + 0.5f);
        Log.e("final height",""+height_final);
        holder.homeFragmentBusinessImageView.getLayoutParams().width  = final_width;
        holder.homeFragmentBusinessImageView.getLayoutParams().height = height_final;