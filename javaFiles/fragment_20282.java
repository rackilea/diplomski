Calendar calendar = Calendar.getInstance();
calendar.set(Calendar.HOUR_OF_DAY, 24);
calendar.set(Calendar.MINUTE, 0);
calendar.set(Calendar.SECOND, 0);

SpinnerDateModel model = new SpinnerDateModel();
model.setValue(calendar.getTime());

JSpinner spinner = new JSpinner(model);