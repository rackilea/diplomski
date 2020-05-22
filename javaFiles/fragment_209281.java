import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create list1 and list2 here
        Integer[] list1 = new Integer[4];
        Integer[] list2 = new Integer[4];

        ListView view = (ListView)this.findViewById(R.id.root);
        view.setAdapter(new ListAdapter(this, list1, list2));
    }

    private static class ListAdapter extends ArrayAdapter<Integer>
    {
        public ListAdapter(MainActivity screen, Integer[] list1, Integer[] list2) 
        {
            super(screen, R.layout.listviewrow, list1);
            this.list1 = list1;
            this.list2 = list2;
            this.activity = screen; // << sorry I forgot this!
        }

        public View getView(int position, View row, ViewGroup parent) 
        {   
            row = activity.getLayoutInflater().inflate(R.layout.listviewrow, parent, false);

            TextView view1 = (TextView)row.findViewById(R.id.item1);
            view1.setText(list1[position] + "");
            TextView view2 = (TextView)row.findViewById(R.id.item2);
            view2.setText(list2[position] + "");

            return row;
        }

        private MainActivity activity;
        private Integer list1[];
        private Integer list2[];
    }
}