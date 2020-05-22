//small change, attachToRoot = false:
View inf = inflater.inflate(R.layout.inflater_layout,r, false);
//LayoutParams always refer to the parent of the actual view:
RelativeLayout.LayoutParams lp  = new    RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//example Rule: 
lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
inf.setLayoutParams(lp);
r.addView(inf) //because we haven't added it yet.