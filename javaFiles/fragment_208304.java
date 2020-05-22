LayoutInflater inflater = getActivity().getLayoutInflater();
View view = inflater.inflate(R.layout.custom_dialog_building,null)

AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
builder.setView(view);

ListView buildingLinkListView = (ListView) view.findViewById(R.id.buildingLinkListView);