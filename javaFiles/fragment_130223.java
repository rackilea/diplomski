//Table Layout parameters
        TableRow.LayoutParams textViewParam = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,1.0f);
        TableLayout tableLayout = (TableLayout) view.findViewById(R.id.fenceTableLayout);
        TableRow trHead = new TableRow(context);
        LayoutParams tableRowParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        trHead.setLayoutParams(tableRowParams);

        TextView nameHead = new TextView(context);
        nameHead.setText("Content left");
        nameHead.setLayoutParams(textViewParam);
        nameHead.setGravity(Gravity.CENTER);
        trHead.addView(nameHead);

        TextView detailHead = new TextView(context);
        detailHead.setText("Content right");
        detailHead.setGravity(Gravity.CENTER);
        detailHead.setLayoutParams(textViewParam);

        trHead.addView(detailHead);
        tableLayout.addView(trHead);