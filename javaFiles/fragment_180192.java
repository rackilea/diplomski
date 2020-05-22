public class ScheduleItemAlternateView extends RelativeLayout {

    private ScheduleItem mItem;  

    public ScheduleItemAlternateView(Context context, ScheduleItem item) {
        super(context);

        mItem = item;

        int textColor = Color.WHITE;
        int accentColor = item.accentColor;

        LayerDrawable buttonDrawable = (LayerDrawable) context.getResources()
            .getDrawable(R.drawable.btn_block);
        buttonDrawable.getDrawable(0).setColorFilter(accentColor,
            PorterDuff.Mode.SRC_ATOP);
        buttonDrawable.getDrawable(1).setAlpha(item.containsStarred ? 255 : 0);

        // Three TextViews to hold the `title`, `roomId`
        // and `teacher&room` independently
        TextView tvTitle = new TextView(context);
        TextView tvRoomId = new TextView(context);
        TextView tvTeacherAndClasses = new TextView(context);

        // Example ids
        tvTitle.setId(100);
        tvRoomId.setId(101);
        tvTeacherAndClasses.setId(102);

        tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources()
            .getDimensionPixelSize(R.dimen.text_size_small));
        tvRoomId.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources()
            .getDimensionPixelSize(R.dimen.text_size_small));
        tvTeacherAndClasses.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources()
            .getDimensionPixelSize(R.dimen.text_size_small));

        tvTitle.setPadding(30, 20, 30, 0);
        tvRoomId.setPadding(30, 20, 30, 0);
        tvTeacherAndClasses.setPadding(30, 5, 30, 20);

        tvTitle.setTextColor(textColor);
        tvRoomId.setTextColor(textColor);
        tvTeacherAndClasses.setTextColor(textColor);

        // Set text
        tvTitle.setText(item.title);        
        tvRoomId.setText(item.roomId);      
        tvTeacherAndClasses.setText(item.teacher + " " + item.classes);

        // LayoutParms
        RelativeLayout.LayoutParams paramsTitle = 
                                 new RelativeLayout.LayoutParams(
                                     RelativeLayout.LayoutParams.WRAP_CONTENT,
                                     RelativeLayout.LayoutParams.WRAP_CONTENT);

        paramsTitle.addRule(RelativeLayout.ALIGN_LEFT, 
                                                  tvTeacherAndClasses.getId());

        RelativeLayout.LayoutParams paramsRoomId = 
                                 new RelativeLayout.LayoutParams(
                                     RelativeLayout.LayoutParams.WRAP_CONTENT,
                                     RelativeLayout.LayoutParams.WRAP_CONTENT);

        paramsRoomId.addRule(RelativeLayout.ALIGN_RIGHT, 
                                                  tvTeacherAndClasses.getId());

        RelativeLayout.LayoutParams paramsTeacherAndClasses = 
                                 new RelativeLayout.LayoutParams(
                                     RelativeLayout.LayoutParams.WRAP_CONTENT,
                                     RelativeLayout.LayoutParams.WRAP_CONTENT);

        paramsTeacherAndClasses.addRule(RelativeLayout.CENTER_HORIZONTAL);
        paramsTeacherAndClasses.addRule(RelativeLayout.BELOW, tvTitle.getId());

        // Add Views to this RelativeLayout
        addView(tvTitle, paramsTitle);
        addView(tvRoomId, paramsRoomId);
        addView(tvTeacherAndClasses, paramsTeacherAndClasses);

        // Set the background as LayerDrawable
        setBackgroundDrawable(buttonDrawable);          
    }
}