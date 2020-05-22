final DateBox dateBox = new DateBox();
dateBox.addValueChangeHandler(new ValueChangeHandler<Date>()
{
    @Override
    public void onValueChange(final ValueChangeEvent<Date> dateValueChangeEvent)
    {
        if (dateValueChangeEvent.getValue().before(today()))
        {
            dateBox.setValue(today(), false);
        }
    }
});
dateBox.getDatePicker().addShowRangeHandler(new ShowRangeHandler<Date>()
{
    @Override
    public void onShowRange(final ShowRangeEvent<Date> dateShowRangeEvent)
    {
        final Date today = today();
        Date d = zeroTime(dateShowRangeEvent.getStart());
        while (d.before(today))
        {
            dateBox.getDatePicker().setTransientEnabledOnDates(false, d);
            d = nextDay(d);
        }
    }
});