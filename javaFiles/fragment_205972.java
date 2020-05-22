/**
 * 
 */
package com.sb.skeleton;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

/**
 * @author rajesh
 *
 */
public class SBEditText extends EditText {

    /**
     * @param context
     */
    public SBEditText(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public SBEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyle
     */
    public SBEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setSelection(int start, int stop) {
        // TODO Auto-generated method stub
        Log.d(SkeletonAppActivity.TOSS, "setSelection");
        super.setSelection(start, stop);
    }


    @Override
    public void setSelection(int index) {
        // TODO Auto-generated method stub
        Log.d(SkeletonAppActivity.TOSS, "selectionChanged");
        super.setSelection(index);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub

        setSelection(getText().length());
        super.onDraw(canvas);
    }

}