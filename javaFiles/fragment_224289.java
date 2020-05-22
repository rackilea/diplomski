private int position=0;
final int[] sentences = new int[]{
    R.String.sentence1, 
    R.String.sentence1, 
    R.String.sentence2, 
    R.String.sentence3, 
    R.String.sentence4
};

//inside onCreate() method
yourButton.setOnClickListener(new View.OnClickListener(){
     public void onClick(View view){
         TextView textView = new TextView(YourActivityClass.this);
         textView.setText(sentences[position++]);
         ((LinearLayout)findViewById(R.id.lnContainer)).addView(textView);
     }
});