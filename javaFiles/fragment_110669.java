LinearLayout summary = findViewById(R.id.linearLayout);
    summary.addView(age_table_populate());

    View age_table  = LayoutInflater.from(ResultActivity.this).inflate(R.layout.age_table,null,false);

    TextView input=(TextView)age_table.findViewById(R.id.title);
    String age_table_label = "label";

    input.setText(age_table_label);

    summary.addView(age_table);