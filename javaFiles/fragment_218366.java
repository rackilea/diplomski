View.OnClickListener buttonListener = new View.OnClickListener() {
        public void onClick(View arg0) {
            switch(arg0.getId()){

        case R.id.button1:
            try {
                tachoCount = new TachoCount();
                _message.setVisibility(View.INVISIBLE);
                tachoCount.start();
            } catch (Exception e) {
                Log.e(TAG, "failed to run TachoCount:" + e.getMessage(), e);
            }
            break;
        case R.id.button3:
            try {
                tachoCount = new TachoCount();
                _message.setVisibility(View.INVISIBLE);
                tachoCount.start();
            } catch (Exception e) {
                Log.e(TAG, "failed to run TachoCount:" + e.getMessage(), e);
            }
            break;
        case R.id.button2:
                try {
                    tachoCount = new TachoCount();
                    _message.setVisibility(View.INVISIBLE);
                    tachoCount.start();
                } catch (Exception e) {
                    Log.e(TAG, "failed to run BTSend:" + e.getMessage(), e);
                }
                break;
        }

   }