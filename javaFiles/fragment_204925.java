public class Admin extends ListActivity
{
    private DBAdapter mDbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);

        mDbAdapter =  = new DBAdapter(this);
        mDbAdapter.open();

        getListView().setAdapter(new PlayerAdapter(this, mDbAdapter..getAllPlayers()));
    }

    private class PlayerAdapter extends BaseAdapter implements OnClickListener
    {
        private Cursor mPlayers;
        private Context mContext;

        public PlayerAdapter(Context context, Cursor players)
        {
            mContext = context; 
            mPlayers = players;
        }

        @Override
        public int getCount()
        {
            return mPlayers.getCount();
        }

        @Override
        public PlayerInfo getItem(int position)
        {
            if (mPlayers.moveToPosition(position))
            {
                String name = mPlayers.getString(mPlayers.getColumnIndex("USERNAME"));
                String password = mPlayers.getString(mPlayers.getColumnIndex("PASSWORD"));
                String email = mPlayers.getString(mPlayers.getColumnIndex("EMAIL");

                return new PlayerInfo(name, password, email);
            }

            return null;
        }

        @Override
        public long getItemId(int position)
        {
            mPlayers.moveToPosition(position);
            return mPlayers.getLong(mPlayers.getColumnIndex("_id");
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            if (convertView == null)
            {
                convertView = LayoutInflater.from(mContext)
                            .inflate(R.layout.list_items, parent, false);
            }

            PlayerInfo playerInfo = getItem(position);
            TextView nameTextView = ViewHolder.get(convertView, R.id.AdminUsername);
            TextView passwordTextView = ViewHolder.get(convertView, R.id.AdminPassword);
            TextView emailTextView = ViewHolder.get(convertView, R.id.AdminEmail);
            Button deleteButton = ViewHolder.get(convertView, R.id.PlayerDelete, position);
            deleteButton.setOnClickListener(this);

            nameTextView.setText(playerInfo.getName());
            passwordTextView.setText(playerInfo.getPassword());
            emailTextView.setText(playerInfo.getEmail());
            return convertView;
        }

        @Override
        public void onClick(View v)
        {
             int position = (Integer) v.getTag();
                mPlayers.moveToPosition(position);
                long id = mPlayers.getLong(mPlayers.getColumnIndex("_id"));
                mDbAdapter.deletePlayer(id);
                mPlayers = mDbAdapter.getAllPlayers();
                notifyDataSetChanged();
                break;
        }
    }

}

    public class PlayerInfo
    {
        private String mName;
        private String mPassword;
        private String mEmail;

        public PlayerInfo(String name, String password, String email)
        {
            mName = name;
            mPassword = password;
            mEmail = email;
        }

        public String getName()
        {
            return mName;
        }

        public String getPassword()
        {
            return mPassword;
        }

        public String getEmail()
        {
            return mEmail;
        }

    }
}