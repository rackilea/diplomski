List<Apps> loadedApps = listAllApps();
    Collections.sort(loadedApps, new Comparator<Apps>() {

        @Override
        public int compare(Apps lhs, Apps rhs) {
            return lhs.getTitle().compareTo(rhs.getTitle());
        }
    });
    // Config.makeColdToast(loadedApps.size());

    for (final Apps a : loadedApps) {
        final TableRow tb = new TableRow(Config.context);
        tb.setId(i + 1000);
        Drawable ico = null;
        try {
            Intent in = pm.getLaunchIntentForPackage(a.getPackageName());
            if (in != null) {
                ico = pm.getActivityIcon(in);

            }
        } catch (NameNotFoundException e) {
        }
        ImageView ima = new ImageView(Config.context);
        ima.setImageDrawable(ico);
        tb.addView(ima, new TableRow.LayoutParams(Config.dpToPx(50), Config.dpToPx(50)));
        TextView name = new TextView(Config.context);
        name.setText(a.getTitle());
        a.setID(i);
        tb.setPadding(Config.dpToPx(25), Config.dpToPx(10), Config.dpToPx(15), Config.dpToPx(10));
        tb.setBackgroundColor(Color.argb(125, 0, 0, 0));
        tb.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = Config.context.getPackageManager().getLaunchIntentForPackage(a.getPackageName());

                if (intent != null) {
                    startActivity(intent);
                }
                tb.setBackgroundColor(Color.TRANSPARENT);
            }

        });
        tb.setOnLongClickListener(new OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {
                Config.makeColdToast("Long click!");

                return false;
            }
        });
        tb.addView(name, new TableRow.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        gv.addView(tb, new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        /*
         * This is the gray line...
         */
        TableRow tl = new TableRow(Config.context);
        tl.setBackgroundResource(R.layout.customborder);
        gv.addView(tl);
        i++;
    }