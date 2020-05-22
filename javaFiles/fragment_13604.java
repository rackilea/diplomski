@Override
public String toString() {
    String answer = "";
    for (int i = 0; i < numCards; i++) {
        answer = answer + "\n" + deck[i].toString();
    }
    return answer;
}