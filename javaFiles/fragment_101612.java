ArrayList<EditText> editTexts = new ArrayList<EditText>();

editTexts.add(nama_pp);
editTexts.add(editetext2);

ArrayList<ImageView> imageViews =  new ArrayList<ImageView>();
imageViews.add(image1);
imageVioew.add(Image2);

boolean nextPage = true;

for (int i = 0; i < editTexts.length();i++) 
    if (editText[i].isEmpty(editText[i].getText.toString())) {
        imageViews[i].setImageResource(R.drawable.espaj_red_checklist);
        nextPage = false;
    }
}