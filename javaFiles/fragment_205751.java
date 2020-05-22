public class Dialog2 extends Dialog {

        int newI;
        Button button;

        public Dialog2(Activity activity, int i, final ModifiedListener listener) {
            super(activity);
            setContentView(R.layout.dialog2);

            newI = i + 12345;
            //when you modify int you have to call
            listener.notify(newI);


            button = findViewById(R.id.dialog2Button);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    close();

                }
            });


        }

        private void close() {
            this.dismiss();
        }
    }