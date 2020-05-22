Holder holder = new Holder();
@Override
public View getView(final int position, View convertView, ViewGroup parent) {

    if (convertView == null) {

        // TODO Auto-generated method stub


        final View rowView;
        convertView = inflater.inflate(R.layout.row_layout, null);
        holder.radioButton_Group_PresentAbsent = (RadioGroup) convertView.findViewById(R.id.radioButton_group_PresentAbsent);
        holder.radioButtonPresent = (RadioButton) convertView.findViewById(R.id.radioButton_present);
        holder.txtlt = (TextView) convertView.findViewById(R.id.text_Lt);
        holder.txtteacher = (TextView) convertView.findViewById(R.id.text_teacher_name);
        holder.radioButtonAbsent = (RadioButton) convertView.findViewById(R.id.radioButton_absent);
        holder.txtStart_time_Picker = (TextView) convertView.findViewById(R.id.txtStartTimePicker);
        holder.txtStart_time_Picker.setFocusable(false);
        holder.txtEnd_time_Picker = (TextView) convertView.findViewById(R.id.txtEndTimePicker);
        holder.txtEnd_time_Picker.setFocusable(false);
        holder.txtlt.setText(class_room[position]);
        holder.txtteacher.setText(teacher_name[position]);
        holder.submitAttendance = (ImageButton) convertView.findViewById(R.id.submit_Attendance);
        holder.submitAttendance.setVisibility(View.VISIBLE);
        holder.spinner_teacher_name = (Spinner) convertView.findViewById(R.id.spinner_teacher_name);
        arrayAdapter1 = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, teacher_name);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.spinner_teacher_name.setAdapter(arrayAdapter1);

        holder.submitAttendance.setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View v) {

                String teacherName, status = null, startTime, endTime;
                holder.dataBaseHelper = new DataBaseHelper(v.getContext());

                startTime = holder.txtStart_time_Picker.getText().toString();
                endTime = holder.txtEnd_time_Picker.getText().toString();
                teacherName = holder.txtteacher.getText().toString();
                DataBaseHelper ds = new DataBaseHelper(context);

                if (holder.radioButtonPresent.isChecked()) {
                    status = holder.radioButtonPresent.getText().toString();
                    holder.dataBaseHelper.insertData(teacherName, status, startTime, endTime);
                    Toast.makeText(context, teacher_name[position] + " is " + status, Toast.LENGTH_SHORT).show();

                } else if (holder.radioButtonAbsent.isChecked()) {
                    status = holder.radioButtonAbsent.getText().toString();
                    holder.dataBaseHelper.insertData(teacherName, status, startTime, endTime);
                    Toast.makeText(context, teacher_name[position] + " is " + status, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Teacher Status is not Mark", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.spinner_teacher_name.setVisibility(View.INVISIBLE);
        holder.txtteacher.setVisibility(View.VISIBLE);

        holder.spinner_teacher_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                for (int a = 0; a < position; a++) {
                    holder.txtteacher.setText(teacher_name[position]);
                    holder.spinner_teacher_name.setVisibility(View.INVISIBLE);
                    holder.txtteacher.setVisibility(View.VISIBLE);
                    holder.radioButtonPresent.setChecked(true);
                    holder.txtEnd_time_Picker.setVisibility(View.VISIBLE);
                    holder.txtStart_time_Picker.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        holder.txtStart_time_Picker.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                TimePickerDialog.OnTimeSetListener tim = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // TODO Auto-generated method stub
                        holder.txtStart_time_Picker.setText(hourOfDay + " : " + minute);
                    }
                };
                new TimePickerDialog(context, tim, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), true).show();

                holder.txtEnd_time_Picker.setVisibility(View.VISIBLE);
            }
        });

        holder.txtEnd_time_Picker.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub
                TimePickerDialog.OnTimeSetListener tim = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // TODO Auto-generated method stub
                        holder.txtEnd_time_Picker.setText(hourOfDay + " : " + minute);
                    }
                };
                new TimePickerDialog(context, tim, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), true).show();

            }
        });

        holder.radioButtonAbsent.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.radioButtonAbsent.isChecked()) {
                    holder.txtEnd_time_Picker.setVisibility(View.INVISIBLE);
                    holder.txtStart_time_Picker.setVisibility(View.INVISIBLE);
                    holder.spinner_teacher_name.setVisibility(View.VISIBLE);
                    holder.txtteacher.setVisibility(View.INVISIBLE);
                } else if (holder.radioButtonPresent.isChecked()) {
                    holder.txtEnd_time_Picker.setVisibility(View.VISIBLE);
                    holder.txtStart_time_Picker.setVisibility(View.VISIBLE);
                    holder.spinner_teacher_name.setVisibility(View.INVISIBLE);
                    holder.txtteacher.setVisibility(View.VISIBLE);
                }
            }
        });
        holder.radioButtonPresent.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.radioButtonPresent.isChecked()) {
                    holder.txtStart_time_Picker.setVisibility(View.VISIBLE);
                    holder.spinner_teacher_name.setVisibility(View.INVISIBLE);
                    holder.txtteacher.setVisibility(View.VISIBLE);
                } else if (holder.radioButtonAbsent.isChecked()) {
                    holder.txtStart_time_Picker.setVisibility(View.INVISIBLE);
                    holder.txtEnd_time_Picker.setVisibility(View.INVISIBLE);
                    holder.spinner_teacher_name.setVisibility(View.VISIBLE);
                    holder.txtteacher.setVisibility(View.INVISIBLE);
                }
            }
        });

        convertView.setTag(holder);
        convertView.setTag(R.id.radioButton_group_PresentAbsent, holder.radioButton_Group_PresentAbsent);
        convertView.setTag(R.id.radioButton_present, holder.radioButtonPresent);

        convertView.setTag(R.id.text_Lt, holder.txtlt);
        convertView.setTag(R.id.radioButton_present, holder.radioButtonPresent);
        convertView.setTag(R.id.text_teacher_name, holder.txtteacher);
        convertView.setTag(R.id.radioButton_absent, holder.radioButtonAbsent);
        convertView.setTag(R.id.txtStartTimePicker, holder.txtStart_time_Picker);
        convertView.setTag(R.id.txtEndTimePicker, holder.txtEnd_time_Picker);
        convertView.setTag(R.id.submit_Attendance, holder.submitAttendance);
        convertView.setTag(R.id.spinner_teacher_name, holder.spinner_teacher_name);
    }
    else
    {
        holder = (Holder) convertView.getTag();
    }
    holder.radioButtonPresent.setTag(position);
    holder.radioButtonAbsent.setTag(position);

    return convertView;
}
public class Holder
{
    protected TextView txtlt, txtteacher;
    RadioButton radioButtonPresent, radioButtonAbsent;
    TextView txtStart_time_Picker,txtEnd_time_Picker;
    Spinner spinner_teacher_name, spinnerDays;
    ImageButton submitAttendance;
    RadioGroup radioButton_Group_PresentAbsent;
    DataBaseHelper dataBaseHelper;
}