float intOperatorSymbol = (int)(Math.random()*3);
float correctAnswer = 0.0;

// operator String


            String operatorSymbol = null; 

                if (intOperatorSymbol == 0){
                    operatorSymbol = "+";
                    correctAnswer = firstNumber + secondNumber;
                }
                if (intOperatorSymbol == 1) {
                    operatorSymbol = "-";
                    correctAnswer = firstNumber - secondNumber;
               }

                if (intOperatorSymbol == 2){
                    operatorSymbol = "*";
                    correctAnswer = firstNumber * secondNumber;
                }

                if (intOperatorSymbol == 3){
                    operatorSymbol = "/";
                    correctAnswer = firstNumber / secondNumber;
                }