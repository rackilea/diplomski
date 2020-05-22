@Override
public void onBindViewHolder(ViewHolder holder, int position) {
    holder.cat_text.setText(objects_.get(position).txt);
    holder.cat_des.setText(objects_.get(position).des);
    holder.img.setImageResource(objects_.get(position).drawable);
}