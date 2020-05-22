import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final int NUMBER_OF_ROWS = 3;

    private static final int XML_TRAVERSAL = 1;
    private static final int ADD_VIEW = 2;

    private static int current_type = ADD_VIEW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(current_type == XML_TRAVERSAL){
            setUpUsingTraversal();
        } else {
            setUpByInflating();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    private void setUpUsingTraversal(){
        setContentView(R.layout.container_view);

        LinearLayout main_view = (LinearLayout) findViewById(R.id.main_view);

        int count = main_view.getChildCount();
        for(int i = 0; i < count ; i++){
            RelativeLayout layout = (RelativeLayout) main_view.getChildAt(i);
            setTextOnViews(layout, i);      
        }

    }

    private void setUpByInflating() {       
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        for(int x = 0; x < NUMBER_OF_ROWS ; x++){
            RelativeLayout row = (RelativeLayout) getLayoutInflater().inflate(R.layout.row_view, layout, false);
            setTextOnViews(row,x);
            layout.addView(row);
        }

        setContentView(layout);
    }

    private void setTextOnViews(ViewGroup view, int position){
        ((TextView)view.getChildAt(0)).setText(Integer.toString(position));
        ((TextView)view.getChildAt(1)).setText("Record: " + Integer.toString(position));    
    }

}