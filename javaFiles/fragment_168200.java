Button btnCheckButton = new Button(parent, SWT.CHECK);
        btnCheckButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if(btnCheckButton.getSelection()) {
                    setSeriesVisibility((Integer)btnCheckButton.getData(seriesName), true);
                } else {
                    setSeriesVisibility((Integer)btnCheckButton.getData(seriesName), false);
                }
            }
        });
        btnCheckButton.setText(seriesName);
        btnCheckButton.setData(seriesName, index);
        btnCheckButton.setSelection(true);