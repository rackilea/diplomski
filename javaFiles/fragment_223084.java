progress.setLayoutParams(progressLayout);
progress.setIndeterminate(false);
progress.setMax(100);
progress.setProgressDrawable(ContextCompat.getDrawable(mContext, R.drawable.progressbar));
progress.setMinimumHeight(0);
progress.setMinimumWidth(150);
progress.setProgress(mat.mProgress);