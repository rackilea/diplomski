int numberInput = Integer.parseInt(userInput);

    binarySearch(psalmsNumbersArray, 0, (psalmsNumbersArray.size() - 1), userInput);
    for (int i = 0; i < psalmTextFileArray.length; i++) {
    index = psalmTextFileArray[i].indexOf(numberInput);
    }
    JOptionPane.showMessageDialog(null, "I found Psalm #" + userInput + ". It is: \n" + psalmTextFileArray[index]);