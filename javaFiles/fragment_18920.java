// See Here 
    ((MovieHolder)holder).buttonViewOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, ""+ position, Toast.LENGTH_LONG).show();
            }
        });
    }