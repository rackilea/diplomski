public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if(itemView == null) {
            itemView = getActivity().getLayoutInflater().inflate(R.layout.list_item, parent, false);
        }
        //Just set the image of the corresponding answerButton
        ReserveButton currentButton = answerButtons.get(position);
        Button butt = (Button) itemView.findViewById(R.id.resultItem);
        butt.setBackground(currentButton.getImage());
        return itemView;
    }