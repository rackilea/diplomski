count++
if (count < words.length){
    textView.setText(words[count]);
}else{
    // Assuming you are inside an activity called MyActivity
    MyActivity.this.finish();
}