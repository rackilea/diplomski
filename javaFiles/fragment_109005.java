public class TodoListActivity extends AppCompatActivity {


// for the calendar
    Calendar calendar = Calendar.getInstance();
    static String getTitleTask;
    static String getDescTask;
    static String getYearTask;
    static String getMonthTask;
    static String getDayTask;
    static String getHourTask;
    static String getMinTask;
    //todolist with databse

    public static final String TAG = "TodoListActivity";
    private TodoHelper mHelper;
    private ListView mTodoListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        // todolist with database
        mHelper = new TodoHelper(this);
        mTodoListView = (ListView) findViewById(R.id.list_todo);
        List<TaskData> tasks = genererTasks();
        TaskAdapter taskAdapter = new TaskAdapter(TodoListActivity.this, tasks);
        mTodoListView.setAdapter(taskAdapter);
        taskAdapter.notifyDataSetChanged();
        mTodoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    System.out.println("This should show when press on one button and should be the item at position"+i);
                    Toast.makeText(TodoListActivity.this, "Hello world", Toast.LENGTH_LONG).show();
                }
            });
    }

    public List<TaskData> genererTasks() {

        List<TaskData> taskDataList;
        TodoHelper.init(TodoListActivity.this);
        taskDataList = TodoHelper.getAllUserData();

        return taskDataList;
    }
}