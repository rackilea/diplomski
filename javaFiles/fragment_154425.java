@Override
    public void onBindViewHolder(final NotaViewHolder viewHolder, final int position) {

        //...
        viewHolder.checkBox.setChecked(checkBoxesState.get(position));
    }