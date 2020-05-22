public AlertDialog.Builder displayDailyOverviewDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.datepicker, null);

        dialog.setTitle("Set Daily Overview");
        dialog.setView(dialogView);

        DatePicker dp = (DatePicker) dialogView.findViewById(R.id.daily_datepicker);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        dp.setMinDate(calendar.getTimeInMillis());
        dp.setMaxDate(new Date().getTime());
        dp.findViewById(Resources.getSystem().getIdentifier("month", "id", "android")).setVisibility(View.GONE);
        dp.findViewById(Resources.getSystem().getIdentifier("year", "id", "android")).setVisibility(View.GONE);

        dialog.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

        dialog.create();

        return dialog;
    }