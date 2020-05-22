LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    for (  ) {
      View listItemView = inflater.inflate(R.layout.detaillistitem, _ListLayout, false);
      _ListLayout.addView(listItemView);

      TextView descriptionText = (TextView) listItemView.findViewById(R.id.Text1);
      descriptionText.setText("");

    }