@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState){
    View view =inflater.inflate(R.layout.assign_pattern_tab_1, container, false);
    nameAndNumberText = (TextView) view.findViewById(R.id.numberToNameView);
    nameToNumberMapping = ContactNameAndNumberUtility
            .getNameToPhoneNumberMapping(getActivity()
            .getApplicationContext());

    for (Map.Entry<String, String> item : nameToNumberMapping.entrySet()) {
        String key = item.getKey();
        String value = item.getValue();

        nameAndNumberText.append(key);
        nameAndNumberText.append(value);
    }
    return view;