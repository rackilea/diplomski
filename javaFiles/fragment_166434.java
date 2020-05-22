SharedPreferences sp = getActivity().getPreferences(Context.MODE_PRIVATE);
    //if your codes in your activity class, you dont need getActivity so you should use this
    //getPreferences(Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sp.edit();
    editor.putInt("your_string_key", yourValue);
    editor.commit();