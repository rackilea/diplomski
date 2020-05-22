public ViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, view);  // To bind view with ButterKnife

                itemView.setOnClickListener(v -> {
                    if (listener != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                        listener.onItemClick(objects.get(getAdapterPosition()));
                    }
                });
     }