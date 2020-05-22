@Override
    public void onClick(View view) {


        switch(view.getId()) {
            case R.id.generateButton:
                generateString();
                break;

            case R.id.send:

                //displayText is a textView
                String text = generateButton.getText().toString(); 

               SharedPreferences pref = this.getSharedPreferences("lado", Context.MODE_PRIVATE);



                Words words = new Words();
                words.setName(text);
                List<Words> wordsList = new ArrayList<>();

                Gson gson = new Gson();
                Dictionary dictionary = gson.fromJson(pref.getString("word", ""), Dictionary.class);
                if (dictionary != null && dictionary.getWordsList() != null) {
                    wordsList.addAll(dictionary.getWordsList());
                    dictionary.setWordsList(wordsList);
                    wordsList.add(words);
                } else {
                    dictionary = new Dictionary();
                    wordsList.add(words);
                    dictionary.setWordsList(wordsList);
                }
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("word", new Gson().toJson(dictionary));
                editor.commit();

                break;


        }