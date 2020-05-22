@Override
public void onClick(View view) {

    CheckBox cb = (CheckBox) view;


    if(cb.isChecked()){

        LinearLayout llLayout = (LinearLayout) cb.getParent();

        for(int i=0; i<((ViewGroup)llLayout).getChildCount(); ++i) {
            View nextChild = ((ViewGroup)llLayout).getChildAt(i);
            if(nextChild instanceof CheckBox && nextChild.getId()==cb.getId() ){

            }else if (nextChild instanceof CheckBox && nextChild.getId()!=cb.getId() ){

                CheckBox cb2=(CheckBox) nextChild;
                cb2.setChecked(false);
            }
        }

    } else{
        LinearLayout llLayout = (LinearLayout) cb.getParent();

       for(int i=0; i<((ViewGroup)llLayout).getChildCount(); ++i) {
            View nextChild = ((ViewGroup)llLayout).getChildAt(i);
            if(nextChild instanceof CheckBox && nextChild.getId()==cb.getId() ){
                CheckBox cb2=(CheckBox) nextChild;
                cb2.setChecked(false);
            }else if (nextChild instanceof CheckBox && nextChild.getId()!=cb.getId() ){
                CheckBox cb2=(CheckBox) nextChild;
                cb2.setChecked(false);

            }
        }
    }
}