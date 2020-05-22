final ArrayList<CircleImageView> circleImageViewlist = new ArrayList< CircleImageView>();
                for (int i = 0; i < Home.arr_category_item_list.size(); i++) {
                    final CircleImageView circleImageView = new CircleImageView(getActivity());
                    circleImageView.setId(i);
                    circleImageView.setBorderColor(getResources().getColor(R.color.gray_border));
                    circleImageView.setBorderWidth(5);
                    circleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    circleImageViewlist.add(circleImageView);
                    circleImageViewlist.get(i).setOnClickListener(this);

                    }

                        @Override
                        public void onClick(View v) {
                            for(int i = 0; i < Home.arr_category_item_list.size(); i++){
                                if(circleImageViewlist.get(i).getId()== v.getId()){
                                    //do your stuff
                                }
                            }
                        }