public void onModuleLoad() {
    final DateBox dateBox = new DateBox();

    dateBox.getDatePicker().addShowRangeHandler(new ShowRangeHandler<Date>() {
        @Override
        public void onShowRange(final ShowRangeEvent<Date> dateShowRangeEvent) {
            final Date today = new Date(); //30 May 3014
            final Date yesterday = new Date(today.getTime()- 24*60*60*1000);

            //disabling yesterday - 29 May of 2014
            dateBox.getDatePicker().setTransientEnabledOnDates(false, yesterday);

        }
    });

    RootPanel.get().add(dateBox);

  }