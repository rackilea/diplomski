final int sdk = android.os.Build.VERSION.SDK_INT;
if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
    rl.setBackgroundDrawable( getResources().getDrawable(R.drawable.loginbackground3) );
} else {
    rl.setBackground( getResources().getDrawable(R.drawable.loginbackground3));
}