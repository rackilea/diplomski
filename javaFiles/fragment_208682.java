@Override
    public void onClick(View v) {
          // add this, this will help you to implement multiple clicklisteners and you can add different methods in each click listener
        switch (v.getId())
        {
            case R.id.InactiveButton:
                 inactiveButton.setImageResource(R.drawable.otherimage);
                break;
            default:break;
        }
    }