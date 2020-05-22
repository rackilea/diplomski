public class CustomEmployeeListAdapter extends BaseAdapter {
    Context context;
    List<Employee> mEmployees;

    ...

    public CustomEmployeeListAdapter(Context ctx, List<Employee> employees) {
        this.context = ctx;
        mEmployees employees;

        ...
    }

    @Override
    public int getCount() {
        return mEmployees.size();
    }

    @Override
    public Object getItem(int position) {
        return mEmployees.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        //get the layout
        ...

        Employee employee = (Employee) getItem(position);

        tvName.setText(employee.getName());
        tvDeg.setText(employee.getDegree());
        tvMobile.setText(employee.getMobile());

        return view;
    }

}