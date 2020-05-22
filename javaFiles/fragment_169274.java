public Holder(View itemView) {
     super(itemView);
   contacts_cardView = (CardView) itemView.findViewById(R.id.contacts_cardView);
   contacts_Name = (TextView)itemView.findViewById(R.id.contacts_Name);
   contacts_Tel = (TextView) itemView.findViewById(R.id.contacts_Tel);
   btnCancel = itemView.findViewById(R.id.btnCancel);

   btnCancel.setOnClickListener(new View.OnClickListener() {

   });

  itemView.setOnClickListener(new View.OnClickListener() {
      int pos=getAdapterPosition();
     Toast.makeText(context,"Pick contact :"+datas.get(pos).getName(), Toast.LENGTH_SHORT);
  });
}