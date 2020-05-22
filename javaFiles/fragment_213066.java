button1.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {

            Intent intent = new Intent(context, PageOne.class);
            startActivity(intent);

        }

    });

    button2.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View arg0) {

            Intent intent = new Intent(context, PageTWO.class); // you made a  
 mistake here you called the PageOne again here while you should call the second. 

            startActivity(intent);

        }

    });