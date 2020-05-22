private void calculate() {
              if (toCalculate) {
                     String input = getinput();
            try {
                if (!isEmpty()) {
                    if (input.contains("x")) {
                        input.replaceAll("x", "*");
                    }
                }

                Expression expression = new ExpressionBuilder(input).build();
                double result = expression.evaluate();
                /*->Write all your code for printing the answer here<-*/
                /*for eg:- result.setText(String.valueOf(twoDForm.format(result)))*/ 
                toCalculate = false;
              } catch (Exception e) {
                 stateError = true;
                 isNumber = false;
                }
                } else {
                 /*->Write all your code for clearing the answer here<-*/
                 /*for eg:- result.setText("")*/    
                 toCalculate = true;
                }

        }