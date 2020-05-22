Glide.with(mContext)
            .load(mDateSet.get(position).getCategoryImages()[position])
            .placeholder(R.drawable.post_image)
            .crossFade()
            .override(700, 400)
            .into(holder.colonies_image);