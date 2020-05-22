@Override
public void setUserVisibleHint(boolean isVisibleToUser) {
    super.setUserVisibleHint(isVisibleToUser);
    if (isVisibleToUser) {
        if (Fragment1.isListClicked){
            if(!Fragment1.favorite_message.equals(""))
                txt.setText(Fragment1.favorite_message);
        }

    }
}