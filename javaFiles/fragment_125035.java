// To convert pixels to dp units
public int GetPixel(float f , Context context)
    {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int)((f * displayMetrics.density) + 0.5f);
    }