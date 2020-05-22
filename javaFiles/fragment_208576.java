if (item.isSelected()) {
                holder.yourbutton.setChecked(true);
            } else {
                holder.yourbutton.setChecked(false);
            }

holder.yourbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ParentEvent event = new ParentEvent();
                    event.view = holder.yourbutton;
                    event.position = position;
                    EventBus.getDefault().post(event);
                    if (holder.yourbutton.isChecked()) {
                        for (int i = 0; i < data.size(); i++) {
                            data.get(i).setSelected(false);
                        }
                        data.get(position).setSelected(true);
                    } else {
                        data.get(position).setSelected(false);
                    }
                    notifyDataSetChanged();
                }
            });