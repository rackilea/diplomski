@Override
        public Object instantiateItem(ViewGroup parent, int position) {

               View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.collection, parent, false);

                ImageView imageView = (ImageView) view
                        .findViewById(R.id.apple);
                imageView.setImageResource(R.drawable.apple);

               final ImageView back_button = (ImageView) view.findViewById(R.id.back_nav_arrow);
               back_button.setOnClickListener(new View.OnClickListener() {
               public void onClick(View view) {

                    //it doesn't matter if you're already in the first item
                    viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
               }
               });



                parent.addView(view,0);


                return view;
        }