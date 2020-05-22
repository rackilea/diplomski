public class TaskViewHolder extends RecyclerView.ViewHolder {

            TextView taskDescriptionView;
            TextView priorityView;

            public TaskViewHolder(View itemView) {
                super(itemView);

                taskDescriptionView = (TextView) itemView.findViewById(R.id.taskDescription);
                priorityView = (TextView) itemView.findViewById(R.id.priorityTextView);

                itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"Clicked " + v.getId(),Toast.LENGTH_SHORT).show();
                }
            });
            }


        }