public class ExpandableListActivity extends AppCompatActivity implements ListActionListener{
    ExpandableAdapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);
        recyclerView = findViewById(R.id.recyclerView);
        loadList();
    }

    private void loadList() {
        List<Routine> routines = getDummyRoutineList();
        adapter = new ExpandableAdapter(routines, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private List<Routine> getDummyRoutineList() {
        List<Routine> list = new ArrayList<Routine>();
        Tasks rt1 = new Tasks("R1 Tasks1", 1);
        Tasks rt2 = new Tasks("R1 Tasks2", 0);
        Tasks rt3 = new Tasks("R1 Tasks3", 1);
        Tasks rt4 = new Tasks("R1 Tasks4", 0);
        Tasks rt5 = new Tasks("R1 Tasks5", 0);
        List<Tasks> r1Tasks = new ArrayList<>();
        r1Tasks.add(rt1);
        r1Tasks.add(rt2);
        r1Tasks.add(rt3);
        r1Tasks.add(rt4);
        r1Tasks.add(rt5);
        Routine r1 = new Routine("Routine 1", r1Tasks);


        Tasks r2t1 = new Tasks("R2 Tasks1", 1);
        Tasks r2t2 = new Tasks("R2 Tasks2", 0);
        Tasks r2t3 = new Tasks("R2 Tasks3", 1);
        Tasks r2t4 = new Tasks("R2 Tasks4", 0);
        Tasks r2t5 = new Tasks("R2 Tasks5", 1);
        List<Tasks> r2Tasks = new ArrayList<>();
        r2Tasks.add(r2t1);
        r2Tasks.add(r2t2);
        r2Tasks.add(r2t3);
        r2Tasks.add(r2t4);
        r2Tasks.add(r2t5);
        Routine r2 = new Routine("Routine 2", r2Tasks);

        list.add(r1);
        list.add(r2);
        return list;
    }

    @Override
    public void onAddTaskClicked(Routine routine) {
        Toast.makeText(this, "On Add Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDeleteTaskClicked(Routine routine, Tasks task, int index) {
        Toast.makeText(this, "On Delete Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTaskCheckChanged(Routine routine, Tasks task, int index, boolean checked) {
        Toast.makeText(this, "On Check changed:"+checked, Toast.LENGTH_SHORT).show();
    }
}