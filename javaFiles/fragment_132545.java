String lastOp = null ; 
        public void actionPerformed(ActionEvent e) {

            String x = e.getActionCommand();
            switch (x) {
            case "/": // an empty case line will execute the elements of the next case.
            case "*": // repeatative, so all operator cases here will execute the
            case "-": // "+" case, but with their operator.
            case "+":
                lastOp = e.getActionCommand();
                saveInput();
                eraseData();
                break;
            case "=":
                switch (op) {
                case "/":
                    fn.divide(inputOne.getText(), fn.getResult());
                case "*":
                    fn.multiply(inputOne.getText(), fn.getResult());
                case "+":
                    fn.sum(inputOne.getText(), fn.getResult());
                case "-":
                    fn.substract(inputOne.getText(), fn.getResult());
                }
                output.setText(Double.toString(fn.getResult()));
                eraseData();
                lastOp = null;
                break;
            }
            default: // this handles all number cases.
                inputOne.setText(inputOne.getText() + x);
                break;
        }