public static <T> void asList(Context context, String url, Class<T[]> clazz, final FutureCallback<List<T>> callback) {
    Ion.with(context)
        .load(url)
        .as(clazz)
        .setCallback(new FutureCallback<T[]>() {
            @Override
                public void onCompleted(Exception e, T[] result) {
                    callback.onCompleted(e, Arrays.asList(result));
                }
        });
}