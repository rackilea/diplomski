import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static com.example.justtesting.R.id.imageView;

public class MainActivity extends AppCompatActivity{

    GestureDetectorCompat detector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int minH = 10;
        final RelativeLayout root = (RelativeLayout) findViewById(R.id.root);
        final ImageView iv = (ImageView) findViewById(imageView);
        final ImageView iv2 = (ImageView) findViewById(R.id.imageView2);

        detector = new GestureDetectorCompat(this, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                int height = iv.getHeight() + iv2.getHeight();
                android.view.ViewGroup.LayoutParams layoutParams = iv.getLayoutParams();
                if ((int) distanceY + layoutParams.height < minH)
                    layoutParams.height = minH;
                else if ((int) distanceY + layoutParams.height > height - minH)
                    layoutParams.height = height-minH;
                else
                    layoutParams.height = (int) distanceY + layoutParams.height;
                android.view.ViewGroup.LayoutParams layoutParams2 = iv2.getLayoutParams();
                layoutParams2.height = height-layoutParams.height;
                iv.setLayoutParams(layoutParams);
                iv2.setLayoutParams(layoutParams2);
                return true;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }
}