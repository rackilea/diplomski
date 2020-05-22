View.OnClickListener clickListener = new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            CustomViewHolder holder = (CustomViewHolder) view.getTag();
                            int position = holder.getAdapterPosition();
            //check here This is where the error os coming from

                            String numbers=feedItemList.get(position).toString();

                            feedItemList.remove(numbers);


                        }
                    };