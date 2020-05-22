SpinnerDateModel model = new SpinnerDateModel();
model.setCalendarField(Calendar.MINUTE);

spinner= new JSpinner();
spinner.setModel(model);
spinner.setEditor(new JSpinner.DateEditor(spinner, "h:mm a"));