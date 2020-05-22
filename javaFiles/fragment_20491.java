Picasso.Builder builder = new Picasso.Builder(mContext);
builder.listener(new Picasso.Listener()
{
    @Override
    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception)
    {
        Timber.d(exception.getMessage());
    }
});

Picasso pic = builder.build();