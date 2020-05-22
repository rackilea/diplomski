public class NotaViewHolder extends RecyclerView.ViewHolder {

        //...
        CheckBox checkBox;


        public NotaViewHolder(final View itemView) {
            super(itemView);

            //...

            checkBox = (CheckBox) itemView.findViewById(R.id.rowCheckBox);

            //...
        }
    }