View view = inflater.inflate(R.layout.tab2, container, false);

    GridView gridview = (GridView) view.findViewById(R.id.gridview);
    gridview.setAdapter(new ImageAdapter(getActivity());

    .
    .
    .

    return view ;