public class JsTree extends Panel{

    private static final long serialVersionUID = 1L;

    public JsTree(final String id, final IModel<List<MyDomainObject>> model){
        super(id);
        this.add(new ListView<MyDomainObject>("list", model){

            private static final long serialVersionUID = 1L;

            @Override
            protected void populateItem(final ListItem<MyDomainObject> item){
                MyDomainObject modelObject = item.getModelObject();
                final Map<String, String> params =
                    Collections.singletonMap("id", modelObject
                        .getObjectId());
                item.add(
                    new BookmarkablePageLink<Void>(
                        "link", MyPage.class,
                        new PageParameters(params)
                    ).add(new Label("label",modelObject.getName()))
                ).setOutputMarkupId(true);

            }
        });
    }
}