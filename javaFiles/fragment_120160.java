Button button = new Button(gridPanel, SWT.PUSH);
button.setText("Item: " + i);
GridData buttonLayoutData = new GridData();
buttonLayoutData.widthHint = 60;
buttonLayoutData.heightHint = 60;
button.setLayoutData(buttonLayoutData);