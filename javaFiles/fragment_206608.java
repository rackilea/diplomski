LayoutInflater inflater = getLayoutInflater();

    View layout = inflater.inflate(R.layout.custom_toast,
            (ViewGroup) findViewById(R.id.custom_toast_layout_id));
    // set a message
    TextView text = (TextView) layout.findViewById(R.id.text);
    text.setText(themessage);

    toast = Toast.makeText(getApplicationContext(),
                    themessage, Toast.LENGTH_LONG);
    toast.setView(layout);
    toast.show();