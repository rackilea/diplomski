for(int c = 0; c < appCols; c++) { // Go through cols
        LinearLayout col = new LinearLayout(context);
        col.setOrientation(LinearLayout.VERTICAL);
        for(int r = 0; r < appRows; r++) { // Go through rows
            Button button = new Button(context);button.setText(allApps.get(n).activityInfo.loadLabel(pm).toString());
            button.setWidth(iconWidth);
            button.setHeight(iconHeight);
            // add app icon
            col.addView(button);
            n++;
        }
        // Add column
        layout.addView(col);
    }