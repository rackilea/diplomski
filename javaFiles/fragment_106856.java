@Override
public void onBindViewHolder(final CoachListViewHolder holder, final int position) {
    Model model = list.get(position);
    holder.radioGroup.check(model.getSelectedId);
    holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
        public void onCheckedChanged(RadioGroup group, int checkedId)
        {
         model.setSelectedId(checkedId);
        }
    });