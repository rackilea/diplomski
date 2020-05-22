if (!ActivitiesTag.get(i).equals("")) {
    Log.d("CardPos", Integer.toString(versionViewHolder.getAdapterPosition()));
    versionViewHolder.title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 56);
}else{
    versionViewHolder.title.setTextSize(TypedValue.COMPLEX_UNIT_SP,"Your Original Text Size");
}