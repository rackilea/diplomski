String answer = "Somewhere over the rainbow";
String guess = "Somewhere over the xxxxxxx";
long correct = IntStream.range(0, Math.min(answer.length(), guess.length()))
        .filter(i -> answer.charAt(i) == guess.charAt(i)).count();
int total = Math.max(answer.length(), guess.length());
System.out.format("(%d/%d) = %d%%%n", correct, total, correct*100/total);