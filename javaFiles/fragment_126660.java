public static @DrawableRes int getDrawable(String url){
        if(url.contains("Myntra")) {
            return R.drawable.myntra;
        } else if(url.contains("Snapdeal")) {
            return R.drawable.snapdeal;
        }
        // Add other if else to support other website url
    }