import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

public class TaskKillerActivity extends Activity {

    private static final String TAG = "TaskKillerActivity";
    TaskListAdapter adapter;
    ListView lv;
 //   RefreshReceiver receiver;
//
//    class RefreshReceiver extends BroadcastReceiver {
//        private static final String TAG = "RefreshReceiver";
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            Log.d(TAG, "refreshing");
//            clearRunningProcessesList();
//            loadRunningProcesses();
//
//        }
//
//    }

    public void clearRunningProcessesList() {
        adapter.clearTasks();
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
       // adapter = new TaskListAdapter(this);
        LinearLayout ll = new LinearLayout(this);
       LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        ll.setLayoutParams(lp1);
        ll.setOrientation(1);
         lv = new ListView(this);
        adapter = new TaskListAdapter(this);
        loadRunningProcesses();

        lv.setAdapter(adapter);


        Button btnKill = new Button(this);
        btnKill.setText("kill task");

        btnKill.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //listItem.setBackgroundColor(Color.BLACK);
                for(TaskObject to :getTasksToKill())
                {
                   activityManager.killBackgroundProcesses(to.getProcessName());

                }
           adapter.clearTasks();
           loadRunningProcesses();
           lv.setAdapter(adapter);
                // TODO Auto-generated method stub

            }
        });
        ll.addView(btnKill);
        ll.addView(lv);
        setContentView(ll);


    }

    private List<TaskObject> getTasksToKill()
    {
        List<TaskObject> tol = new ArrayList<TaskObject>();

        for(int i =0;i<adapter.getCount();i++)
        {
            //RelativeLayout rl = (RelativeLayout)lv.getChildAt(i);

            TaskObject to = adapter.getItem(i);
            //CheckBox  cb = (CheckBox)rl.getChildAt(0);
            if(to.isToKill())
            {
                tol.add(to);
            }
        }

        return tol;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
       // getApplicationContext().unregisterReceiver(receiver);
    }

    public void loadRunningProcesses() {

        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appinfolist = activityManager
                .getRunningAppProcesses();

        Log.d(TAG, "AppInfoList Size: " + appinfolist.size());

        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : appinfolist) {
            TaskObject runningtask = new TaskObject();
            runningtask.setPid(runningAppProcessInfo.pid);
            runningtask.setProcessName(runningAppProcessInfo.processName);
            adapter.addTask(runningtask);
        }
    }

    class TaskObject {
        private int pid;
        private String processName;
        private boolean toKill;

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getProcessName() {
            return processName;
        }

        public void setProcessName(String processName) {
            this.processName = processName;
        }

        public boolean isToKill() {
            return toKill;
        }

        public void setToKill(boolean toKill) {
            this.toKill = toKill;
        }
    }

    class TaskListAdapter extends BaseAdapter {

        private static final String TAG = "TaskListAdapter";

        ArrayList<TaskObject> list;
        Context context;

        public TaskListAdapter(Context context) {
            Log.d(TAG, "created new task list adapter");
            this.context = context;
            if (list == null) {
                list = new ArrayList<TaskKillerActivity.TaskObject>();
            }
        }

        public void addTask(TaskObject taskObject) {
            list.add(taskObject);
        }

        public void clearTasks() {
            list.clear();
            Log.d(TAG, "list size:" + list.size());
            this.notifyDataSetChanged();
        }

        public int getCount() {
            return list.size();
        }

        public TaskObject getItem(int position) {
            return list.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(final int position, View convertView, ViewGroup parent) {
           // LayoutInflater inflater = LayoutInflater.from(context);
           // View view = inflater.inflate(R.layout.taskitem, null);
            RelativeLayout rl = new RelativeLayout(context);
            TextView textPid = new TextView(context);
            textPid.setId(222222);
            textPid.setText(Integer.toString(getItem(position).getPid()));

            TextView textName = new TextView(context);
            textName.setId(333333);
            textName.setText(getItem(position).getProcessName());

            CheckBox chckKill = new CheckBox(context);
            chckKill.setOnClickListener(new View.OnClickListener() {

      public void onClick(View v) {
                //is chkIos checked?
        if (((CheckBox) v).isChecked()) {
            getItem(position).setToKill(true);
        }

      }
    });


            chckKill.setTag(getItem(position).getPid());
            chckKill.setId(11111111);

            RelativeLayout.LayoutParams lp2 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

             rl.addView(chckKill,lp2);


            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
            lp.addRule(RelativeLayout.RIGHT_OF, chckKill.getId());
            lp.setMargins(25,0,0,0);
            rl.addView(textName,lp);

            RelativeLayout.LayoutParams lp1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
            lp1.addRule(RelativeLayout.RIGHT_OF, chckKill.getId());
            lp1.setMargins(25,20,0,0);
            rl.addView(textPid,lp1);


            return rl;
        }

    }
}