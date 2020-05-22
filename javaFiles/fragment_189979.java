boolean isRude = false;
    for (String oneword : words) {
        if(message.toLowerCase().contains(oneword)) {
            isRude = true;
            break;
        }
    }

    if (isRude)
        System.out.println("Sentence contains profanity");
     else
        System.out.println("Sentence does not contain profanity");