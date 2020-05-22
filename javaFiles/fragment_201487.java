ViewStub vs = new ViewStub(this);
  vs.setId(R.id.viewstub_id);
  vs.setLayoutResource(R.layout.use_this_layout);
  vs.setInflatedId(R.id.inflated_stub);

  LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
  vs.setLayoutParams(lp);

  ConstraintLayout cl = findViewById(R.id.viewStubWrapper);
  cl.addView(vs);
  vs.inflate();