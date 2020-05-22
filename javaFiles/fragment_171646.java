public class NetworkImageView extends ImageView {

private String imageURL;

/**
 * Resource ID of the image to be used as a placeholder until the network image is loaded.
 */
private int mDefaultImageId;

/**
 * Resource ID of the image to be used if the network response fails.
 */
private int mErrorImageId;

private Bitmap bitmap;

public NetworkImageView(Context context) {
    super(context);
}

public NetworkImageView(Context context, AttributeSet attrs) {
    super(context, attrs);
}

public NetworkImageView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
}

public String getImageURL() {
    return imageURL;
}

public void setImageUrl(String imageURL) {
    this.imageURL = imageURL;
    Glide.with(getContext())
            .load(imageURL)
            .override(200, 200)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(this);
}

/**
 * Sets the default image resource ID to be used for this view until the attempt to load it
 * completes.
 */
public void setDefaultImageResId(int defaultImage) {
    mDefaultImageId = defaultImage;
}

/**
 * Sets the error image resource ID to be used for this view in the event that the image
 * requested fails to load.
 */
public void setErrorImageResId(int errorImage) {
    mErrorImageId = errorImage;
}

public void setLocalImageBitmap(Bitmap bitmap) {
    this.bitmap = bitmap;
}