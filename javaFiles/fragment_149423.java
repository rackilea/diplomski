holder.editBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent edit_intent = new Intent(holder.authorText.getContext(), EditActivity.class);
            edit_intent.putExtra("text", textList.get(position).getBody());
            edit_intent.putExtra("id", textList.get(position).textId);
            edit_intent.putExtra("position", position);
            ((Activity) context).startActivityForResult(edit_intent, 1);
        }
    });