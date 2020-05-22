//if you added an extra TextView in your fragment_message.xml
TextView counter = (TextView) view.findViewById(R.id.yourcounterid);

counter.setText(message.getCounter());

//if you want to add the number in your messageView:
messageView.setText(message.getMessage() + " " + message.getCounter());