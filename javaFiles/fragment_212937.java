public class HomeButtonHandler implements OnClickListener{

        @Override
        public void onClick(View v) {
            Intent menuIntent = new Intent(v.getContext(),Menu.class);
            v.getContext().startActivity(menuIntent);            

        }

    }