final int positionForListener = position;
ImageButton MyImageButton = (ImageButton) Holder.getBase().findViewById(R.drawable.ic_playvert);        /* listner 1 */
            MyImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast ToastCourt = Toast.makeText(getContext(), DataOfListView.get(classPosition).getPseudoUser(), Toast.LENGTH_SHORT);
                    ToastCourt.show();
                    Log.i("position", ""+positionForListener);
                }
            });