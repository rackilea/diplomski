import android.content.Context;
 import android.content.Intent;
 import android.os.Bundle;
 import android.support.v4.app.Fragment;
 import android.support.v4.widget.SwipeRefreshLayout;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.AbsListView;
 import android.widget.AdapterView;
 import android.widget.ListView;
 import android.widget.ProgressBar;
 import android.widget.TextView;

 import com.shuan.Project.R;
 import com.shuan.Project.Utils.Common;
 import com.shuan.Project.adapter.ConnectAdapter;
 import com.shuan.Project.asyncTasks.GetHome;
 import com.shuan.Project.asyncTasks.GetPost;
 import com.shuan.Project.employer.PostViewActivity;
 import com.shuan.Project.list.Sample;

 import java.util.ArrayList;
 import java.util.HashMap;

 public class OffersFragment extends Fragment implements AbsListView.OnScrollListener {


private ArrayList<Sample> list;
private ConnectAdapter adapter;
private ListView listView;
private HashMap<String, String> cData;
private Common mApp;
private Context mContext;
private ProgressBar progressBar;
private SwipeRefreshLayout swipe;
private int preLast;


public OffersFragment() {
    // Required empty public constructor
}


@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment

    mContext=getActivity();
    mApp= (Common) mContext.getApplicationContext();
    View view = inflater.inflate(R.layout.fragment_employer_home, container, false);

    swipe = (SwipeRefreshLayout) view.findViewById(R.id.swipe);
    listView = (ListView) view.findViewById(R.id.post);
    progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);

    list = new ArrayList<Sample>();

    new GetPost(getActivity(), listView, progressBar, mApp.getPreference().getString(Common.u_id,""),"all", swipe).execute();


    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            TextView txt = (TextView) view.findViewById(R.id.jId);
            TextView txt1= (TextView) view.findViewById(R.id.frm_id);
            Intent in=new Intent(getActivity(),PostViewActivity.class);
            in.putExtra("jId",txt.getText().toString());
            in.putExtra("frmId",txt1.getText().toString());
            in.putExtra("apply","no");
            startActivity(in);
        }
    });
    listView.setOnScrollListener(this);
    swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            new GetHome(getActivity(), listView, progressBar, mApp.getPreference().getString(Common.u_id, ""), "all",swipe).execute();
        }
    });

    return view;
}

@Override
public void onScrollStateChanged(AbsListView view, int scrollState) {

}

@Override
public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    if (view.getId() == R.id.post) {
        if (firstVisibleItem == 0) {
            swipe.setEnabled(true);
            int lastItem = firstVisibleItem + visibleItemCount;
            if (lastItem == totalItemCount) {
                if (preLast != lastItem) {
                    preLast = lastItem;
                    //Toast.makeText(getActivity(), "In Last", Toast.LENGTH_SHORT).show();
                }

            }else{

            }
        } else {
            swipe.setEnabled(false);
        }
    }
  }
}