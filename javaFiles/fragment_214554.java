public class CustomEmployeeListAdapter extends BaseAdapter {
    Context context;
    String[] EmpName;
    String[] EmpDeg;
    String[] EmpMobile;

    ...

    @Override
    public Object getItem(int position) {
        return EmpName[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    ...

}