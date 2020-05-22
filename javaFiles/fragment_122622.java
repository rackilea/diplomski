try {
        randWord(readFile());

        System.out.println(answerWord);

        while (i < answerWord.length()){
            displayWord += "-";
            i++;
        }
        TextView displayText = (TextView) findViewById(R.id.display_word);
        displayText.setText(displayWord);

    } catch (Exception e) {
        e.printStackTrace();
    }