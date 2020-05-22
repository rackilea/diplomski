public class AlwaysVisibleAjaxNavigationToolbar extends AjaxNavigationToolbar{

    public AlwaysVisibleAjaxNavigationToolbar (final DataTable<?, ?> table)
    {
        super(table);
    }

    @Override
    protected void onConfigure()
    {
        super.onConfigure();
        setVisible(true);
    }

}