button.SetOnclickListener(new OnclickListener(){
    public void onClick(View v){
        //Update shared preferences with desired
        //font size here

        //Instance of your IndexCustomAdapter that you attatched to your listview
        indexCustomAdapter.notifyDataSetChanged();

    }
})