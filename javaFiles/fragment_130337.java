upvote.setOnClickListener( //in here
            new View.OnClickListener(){
                public void onClick(View v){
                    comments.get(position)[1] = Integer.toString(Integer.parseInt(comments.get(position)[1]) + 1); //updating vote value
                    upvote.setColorFilter(Color.argb(230, 255, 150, 0)); //changing button color
                    Log.d("DEBUGGGGGG!!!!!!", comments.get(position)[1]); //debug log, works
                    // refreshing the view so that the arrays with update values are reloaded???
                    notifyDataSetChanged();
                }
            }
        );