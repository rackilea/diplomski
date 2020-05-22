...

columns.add(new UserActionsColumn(new Model<String>(" ")));

...

private class UserActionsColumn extends AbstractColumn<CallDetailRecord> {
private static final long serialVersionUID = 1L;

public UserActionsColumn(IModel<String> displayModel) {
  super(displayModel);
}

@Override
public void populateItem(Item<ICellPopulator<CallDetailRecord>> cellItem,
                         String componentId,
                         final IModel<CallDetailRecord> rowModel)
{
  cellItem.add(new UserActionPanel(componentId, rowModel));
}
}

private class UserActionPanel extends Panel {
private static final long serialVersionUID = 1L;

public UserActionPanel(String id, final IModel<CallDetailRecord> model) {
  super(id);
  add(new AjaxLink<CallDetailRecord>("viewLink", model) {
    private static final long serialVersionUID = 1L;

    @Override
    public void onClick(AjaxRequestTarget target) {

      //actions to do when link is clicked
    }
  });
}
}