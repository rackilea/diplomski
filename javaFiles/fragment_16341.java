for (String string : myString) {
            View view = new View(this); 
            view = inflateEditRow(string);
            viewHolder = (MyWrapper)view.getTag();
            viewHolder.getView.setOnClickListener(this);
          // Log.i("Law", "Id val " + a);
          //  view.setId(++a);
            myLayout.addView(view);
        }