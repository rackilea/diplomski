new AsyncTask<CartsPay,Void,Void>(){

        CartsPay cartsPay;

        @Override
        protected Void doInBackground(CartsPay... params) {

            this.cartsPay = params[0];

            // Your code ...

            return null;
        }

        public AsyncTask setRQ(CartsPay cartsPay){
            this.cartsPay= cartsPay;
            return this;
        }

    }.execute(cartsPay);