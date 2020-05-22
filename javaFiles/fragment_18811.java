final Context context = this;
ArrayAdapter<String> adopter = new ArrayAdapter<String>(this,
            R.layout.week_flash_card, R.id.txt_title, course)
{
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        super.getView(position, convertView, parent);
        //convertView = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE).inflate(R.layout.week_flash_card, null);
        Button button = convertView.findViewById(R.id.bPractice_deck);
        button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                switch(position)
                {
                    case 0:
                    {
                        // your code goes here
                        break;
                    }
                    case 1:
                    {
                        // your code goes here
                        break;
                    }
                    // etc...
                }

            }
        });
        return convertView;
    }
};
setListAdapter(adopter);