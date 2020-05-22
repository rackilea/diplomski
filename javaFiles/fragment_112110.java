class MyPage extends Page {
    private Date startDate;
    private Date endDate;

    public MyPage() {
        Form form = new Form("form"){ ... submit logic etc ...};
        add(form);
        form.add(new DateField("startDate", new PropertyModel<Date>(this, "startDate")));
        form.add(new DateField("endDate", new PropertyModel<Date>(this, "endDate")));

        IModel<List<Item>> itemsModel = new LoadableDetachableModel<List<Item>>(){
            @Override
            protected List<Item> load() {
                return logParseDao.findByDates(startDate, endDate);
            }
        };
        add(new ListView<Item>("items", itemsModel) { ... });
    }
}