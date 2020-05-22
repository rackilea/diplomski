@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    linkButton = (Button) findViewById(R.id.link_button);
    debugTxt = (TextView) findViewById(R.id.debugText);
    lv = (ListView) this.findViewById(R.id.filelist);

    registerForContextMenu(lv);

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
    lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
    lv.setAdapter(adapter);

    linkButton.setOnClickListener(new OnClickListener()
    { 
        @Override
        public void onClick(View v) 
        {
            onClickLink();
        }
    });

    mDbxAcctMgr = DbxAccountManager.getInstance(getApplicationContext(), appKey, appSecret);
}

@Override
public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)
{ //here u set u rute
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.login, menu);
}