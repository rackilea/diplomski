if(type.equals("Link"))
{
   holder.itemView.setClickable(true);
   holder.itemView.setOnClickListener(new View.OnClickListener()
   {
        @Override
        public void onClick(View view)
        {
            // do smoethink
        }
    });
}
else
{
   holder.itemView.setClickable(false);
}