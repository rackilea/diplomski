// Assuming the String would be like a repetition of [word][space][number][b][\n]
    String testString = "xyz 100b\nabc 200b\ndef 400b";

    // Split by both endOfLine and space
    String[] pieces = testString.split("\n| ");

    String answer = "";

    // pair index should contain the word, impair is the integer and 'b' letter
    for (int i = 0; i < pieces.length; i++) {
        if(i % 2 != 0 ) {
            answer = answer + "answer " + ((i/2)+1) + ": " + pieces[i] + "\n";
        }
    }
    System.out.println(answer);