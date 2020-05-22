package com.humanoid.sigma;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
private Context mContext;


public Integer[] Tattoos = {
        R.drawable.tattoo1, R.drawable.tattoo2,
        R.drawable.tattoo3, R.drawable.tattoo4,
        R.drawable.tattoo5, R.drawable.tattoo6,
        R.drawable.tattoo7, R.drawable.tattoo8,
        R.drawable.tattoo9, R.drawable.tattoo10, 
        R.drawable.tattoo11, R.drawable.tattoo12,
        R.drawable.tattoo13, R.drawable.tattoo14,
        R.drawable.tattoo15, R.drawable.tattoo16,
        R.drawable.tattoo17, R.drawable.tattoo18,
        R.drawable.tattoo19, R.drawable.tattoo20, 
        R.drawable.tattoo21, R.drawable.tattoo22,
        R.drawable.tattoo23, R.drawable.tattoo24,
        R.drawable.tattoo25, R.drawable.tattoo26,
        R.drawable.tattoo27, R.drawable.tattoo28,
        R.drawable.tattoo29, R.drawable.tattoo30, 
        R.drawable.tattoo31, R.drawable.tattoo32,
        R.drawable.tattoo33, R.drawable.tattoo34,
        R.drawable.tattoo35, R.drawable.tattoo36,
        R.drawable.tattoo37, R.drawable.tattoo38,
        R.drawable.tattoo39, R.drawable.tattoo40, 
        R.drawable.tattoo41, R.drawable.tattoo42,
        R.drawable.tattoo43, R.drawable.tattoo44,
        R.drawable.tattoo45, R.drawable.tattoo46,
        R.drawable.tattoo47, R.drawable.tattoo48,
        R.drawable.tattoo49, R.drawable.tattoo50, 
        R.drawable.tattoo51, R.drawable.tattoo52,
        R.drawable.tattoo53, R.drawable.tattoo54,
        R.drawable.tattoo55, R.drawable.tattoo56,
        R.drawable.tattoo57, R.drawable.tattoo58,
        R.drawable.tattoo59, R.drawable.tattoo60, 
        R.drawable.tattoo61, R.drawable.tattoo62,
        R.drawable.tattoo63, R.drawable.tattoo64,
        R.drawable.tattoo65, R.drawable.tattoo66,
        R.drawable.tattoo67, R.drawable.tattoo68,
        R.drawable.tattoo69, R.drawable.tattoo70, 
        R.drawable.tattoo71, R.drawable.tattoo72,
        R.drawable.tattoo73, R.drawable.tattoo74,
        R.drawable.tattoo75, R.drawable.tattoo76,
        R.drawable.tattoo77, R.drawable.tattoo78,
        R.drawable.tattoo79, R.drawable.tattoo80,
        R.drawable.tattoo81, R.drawable.tattoo82

};

// Constructor
public ImageAdapter(Context c){
    mContext = c;
}

public int getCount() {
    return Tattoos.length;
}

public Object getItem(int position) {
    return Tattoos[position];
}

public long getItemId(int position) {
    return 0;
}

public View getView(int position, View convertView, ViewGroup parent) {
    //This actually is a bad solution, because every time convertView is reused, you will still initialize new ImageView, which is wrong
    //ImageView imageView = new ImageView(this.mContext);
    //new BitmapWorkerTask(imageView).execute(Tattoos[position]);
    //return imageView;

    //Better solution
    ImageView imageView = null;

    if (convertView == null) {
        imageView = new ImageView(this.mContext);
        new BitmapWorkerTask(imageView).execute(Tattoos[position]);
        //create new ImageView if it is not present and populate it with some image
    } else {
        imageView = (ImageView) convertView;
        //re-use ImageView that already exists in memory
    }

return imageView;
}


class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {
        private final WeakReference<ImageView> imageViewReference;
        private int data = 0;

        public BitmapWorkerTask(ImageView imageView) {
            // Use a WeakReference to ensure the ImageView can be garbage collected
            imageViewReference = new WeakReference<ImageView>(imageView);
        }

        // Decode image in background.
        @Override
        protected Bitmap doInBackground(Integer... params) {
            data = params[0];
            return decodeSampledBitmapFromResource(ImageAdapter.this.mContext.getResources(), data, 100, 100);
        }

        // Once complete, see if ImageView is still around and set bitmap.
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (imageViewReference != null && bitmap != null) {
                final ImageView imageView = imageViewReference.get();
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    imageView.setLayoutParams(new GridView.LayoutParams(100, 70));
                }
            }
        }
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            // Calculate ratios of height and width to requested height and width
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            // Choose the smallest ratio as inSampleSize value, this will guarantee
            // a final image with both dimensions larger than or equal to the
            // requested height and width.
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }

}