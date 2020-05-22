answer = input.getText();
        for(int i = 0; i < arrayCounter;i++){
            newNumber = answer.substring(counterOne, counterTwo);
            stringArray[i] = newNumber;
            counterOne += 3;
            counterTwo += 3;
        }