if(matchesArrayList.get(position).getCompanyLink() != null){
    holder.companyImage.setOnClickListener(onClickListener);
    holder.companyImage.setTag(position);
}
else {
    holder.companyImage.setOnClickListener(null);
}