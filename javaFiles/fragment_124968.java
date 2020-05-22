public SubEventListAdapter(Context context, ArrayList<MobileSubEvent> items,  MobileSubActivity parentSubActivity, ListView listView)
        {
            super(context, R.layout.view_select_event_item, items);
            this._items = items;
            this._context = context;
            this.parentSubActivity = parentSubActivity;
            this.listView = listView;
        }