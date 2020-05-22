// find the textview in the layout
            textView = (TextView)findViewById(R.id.textView);

    // do the search, get results
...
    // set textview's text, at this moment textView must not be null
            textView.setText(kbuilder.toString());