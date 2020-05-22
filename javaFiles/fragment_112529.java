String message;
if(word2.compareTo(word1) < 0) { //word2 < word1
    if(word3.compareTo(word1) < 0) { //word3 < word1
        if(word3.compareTo(word2) < 0) { //word3 < word2
            message = word3 + word2 + word1;
        } else { //word2 <= word3
            message = word2 + word3 + word1;
        }
    } else { //word1 <= word3
        message = word2 + word1 + word3;
    }
} else { //word1 <= word2
    if(word3.compareTo(word2) < 0) { //word3 < word2
        if(word3.compareTo(word1) < 0) { //word3 < word1
            message = word3 + word1 + word2;
        } else { //word1 <= word3
            message = word1 + word3 + word2;
        }
    } else { //word2 <= word3
        message = word1 + word2 + word3;
    }
}