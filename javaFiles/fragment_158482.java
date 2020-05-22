public class CourseCompleteAdapter extends ArrayAdapter<CourseCompletedInnerData> {
private Context context;
int  layout;
ArrayList<CourseCompletedInnerData> data;
public CourseCompleteAdapter(Context context, int layout, ArrayList<CourseCompletedInnerData> data) {
    super(context, layout,data);
    this.data = data;
    this.layout = layout;
    this.context =context;
}

@NonNull
@Override
public View getView(int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
        LayoutInflater inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, parent, false);
    }
    TextView tvScore = (TextView)convertView.findViewById(R.id.txtcoursesinnerscore);
    TextView tvActionstatus = (TextView)convertView.findViewById(R.id.txtcoursesinneractionstatus);
    tvScore.setText(data.get(position).getScore());
    tvActionstatus.setText(data.get(position).getAction_status());
     return convertView;
}