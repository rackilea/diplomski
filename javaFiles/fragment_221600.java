public static int getImageId(Context context, String imageName) {
    return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
}

public static int getRawResourceId(Context context, String rawName) {
    return context.getResources().getIdentifier("raw/" + rawName, null, context.getPackageName());
}