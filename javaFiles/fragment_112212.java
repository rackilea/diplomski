public View getView(int position, View convertView, ViewGroup parent) {
     Message message = (Message) this.getItem(position);


ViewHolder holder;
if (convertView ==null) {           
    holder = new ViewHolder();
    convertView = LayoutInflater.from(mContext).inflate(R.layout.chat_row, parent,false);
    holder.sender = (TextView) convertView.findViewById(R.id.textVSender);
    holder.message = (TextView) convertView.findViewById(R.id.message_text1);
    holder.date = (TextView) convertView.findViewById(R.id.textVDate);
    convertView.setTag(holder);
} 


    holder = (ViewHolder) convertView.getTag();
    holder.sender.setText(message.getSender());
    holder.message.setText(message.getMessage());
    holder.date.setText(message.getDate());

    LayoutParams lp = (LayoutParams) holder.message.getLayoutParams();

    if (message.isStatusMessage()) {

        holder.message.setBackgroundDrawable(null);
        holder.sender.setText(message.getSender());         
            holder.sender.setTextColor(Color.parseColor("#405478"));

    } else {

        if (message.isMine()) {                 
            holder.message.setBackgroundResource(R.drawable.speech_bubble_green);                   
            lp.gravity = Gravity.RIGHT;
        } else {                    
            holder.message.setBackgroundResource(R.drawable.speech_bubble_orange);
            lp.gravity = Gravity.LEFT;
        }
        holder.message.setLayoutParams(lp);             
    }           


return convertView;
}