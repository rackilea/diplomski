if(id == 0){
    bookName.setText(books[i]);
    personalTag.setVisibility(View.VISIBLE);
} else {
    bookName.setText(context.getString(id));
    personalTag.setVisibility(View.GONE);
}