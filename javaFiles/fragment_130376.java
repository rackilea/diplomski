package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;

/**
 *
 */

public class MySwipeRefreshLayout extends SwipeRefreshLayout {
    private boolean settingEnabled = false;

    public MySwipeRefreshLayout(Context context) {
        super(context);
    }

    public MySwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setEnabled(boolean enabled) {
        try {
            settingEnabled = true;
            super.setEnabled(enabled);
        } finally {
            settingEnabled = false;
        }
    }

    @Override
    void reset() {
        if (!settingEnabled) {
            super.reset();
        }
    }
}