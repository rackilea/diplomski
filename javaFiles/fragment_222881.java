public class EmployeeList_Adapter extends BaseAdapter
{
    Context context;
    ArrayList<Employee> Employee_List;

    protected SQLiteDatabase db;


    public EmployeeList_Adapter(Context context,
            ArrayList<Employee> employee_List) {
        super();
        this.context = context;
        Employee_List = employee_List;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return Employee_List.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return Employee_List.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup arg2) {
        // TODO Auto-generated method stub

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.staff_employee_list_item, null);
        }
         if( position == 0)
        {
            Employee_List.remove(position);
        }

        Employee EmployeeListItems = Employee_List.get(position);
        TextView tvID = (TextView) convertView.findViewById(R.id.textViewStaff_emp_Id);
        tvID.setText(EmployeeListItems.getEmployeeId()+"");

        ImageView imgProfile = (ImageView) convertView.findViewById(R.id.imgStaff_Emp);


        TextView tvName = (TextView) convertView.findViewById(R.id.textViewStaff_Emp_ame);
        tvName.setText(EmployeeListItems.getName());

        TextView tvDepartment = (TextView) convertView.findViewById(R.id.textViewStaff_Emp_Department);
        tvDepartment.setText(EmployeeListItems.getDepartment());


        TextView tvDesignation = (TextView) convertView.findViewById(R.id.textViewStaff_Emp_Designation);
        tvDesignation.setText(EmployeeListItems.getDesignation());

        TextView tvPerformanceDate = (TextView) convertView.findViewById(R.id.textDate);
        tvPerformanceDate.setText(EmployeeListItems.getDate());

        TextView tvPerformanceRate = (TextView) convertView.findViewById(R.id.empLoyeeRate);
        tvPerformanceRate.setText(EmployeeListItems.getPerformancerate());

        final Employee empPOsition = Employee_List.get(position);
        int positionA = Employee_List.indexOf(empPOsition);

        notifyDataSetChanged();
        System.out.println(" empPOsition = " + positionA);



        return convertView;
    }

}