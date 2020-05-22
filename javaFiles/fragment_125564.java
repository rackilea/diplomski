setOnLongClickListener(new OnLongClickListener() {
        @Override
        public boolean onLongClick(View arg0) {
            switch (arg0.getId()) {

                case R.id.bFOR:
                    try {
                        dataOutputStream.writeBytes("b");
                        //dataOutputStream.writeBytes("a");
                    } catch (UnknownHostException e) {//catch and
                        outputText(e.getMessage());//display errors
                    } catch (IOException e) {//catch and
                        outputText(e.getMessage());//display errors
                    }

                    break;
            }
        }
    });