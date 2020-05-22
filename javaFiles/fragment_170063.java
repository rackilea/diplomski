@Test(expected = ItemDiscontinuedException)
public void createWidgetShouldRejectDiscontinuedWidget() {
    WidgetDao mockDao = mock(WidgetDao.class);
    WidgetService service = new WidgetService(mockDao);
    when(mockDao.countDiscontinued("someCode").thenReturn(1);

    Widget widget = new Widget("someCode");
    service.createWidget(widget);                
}