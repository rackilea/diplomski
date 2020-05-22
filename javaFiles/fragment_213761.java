public static int getResourceId(Context context, String name, String resourceType) {
    return context.getResources().getIdentifier(name, resourceType, context.getPackageName());
}

int iconId = getResourceId(Activity.this, image, "drawable");    

ImageView categoryIcon = (ImageView) v.findViewById(R.id.category_icon);
categoryIcon.setImageResource(iconId);