ll.setOnClickListener(new OnClickListener() {

        public void onClick(View v) {



            if(chooser) {
                Intent intent = Intent.createChooser(i, "Complete With");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            } else
                mContext.startActivity(i);

        }
    });