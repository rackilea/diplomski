@Override
public void onBindViewHolder(ChooseOptionHolder holder, int position) {

    try {
         holder.contacts_name.setText(contact_name_list.get(position));
         holder.phone_number.setText(phone_nums.get(position));

         if(selectedItems.get(position)){
              view.setSelected(true);
              contacts_name.setTextColor(Color.WHITE);
              phone_number.setTextColor(Color.WHITE);
         }else {
             view.setSelected(false);
             contacts_name.setTextColor(Color.BLACK);
             phone_number.setTextColor(Color.BLACK);
         }
   } catch (Exception e) {
    e.printStackTrace();
   }
}