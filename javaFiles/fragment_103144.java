String cardInfo;
String cardNumberString = cardNumber + ","; // makes sure that you don't get your
                                            // id in the middle of a value
while((line = br.readLine()) != null) {
    if(line.indexOf(cardNumberString) != -1)
        cardInfo = line;
}