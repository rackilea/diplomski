TextView pvoce = (TextView) findViewById(R.id.pvoce);
TextView papp = (TextView) findViewById(R.id.papp);

if (escolhaApp == "pedra" && escolhaUsuario == "tesoura" || escolhaApp == "papel" && escolhaUsuario == "pedra" || escolhaApp == "tesoura" && escolhaUsuario == "papel") {
            textoResultado.setText("    You Lose   ");
            // String soma = 1; // wrong as java is statically typed language, you can't assign a int into a String 
            int soma = 1;

           //  int totalapp = (soma + papp); // papp is of TextView type, you need to get its text by getText(), convert it to String by .toString(), and then into int to make the integer addition valid
            int totalapp = soma + Integer.parseInt(papp.getText().toString());

            String totalappString = Integer.toString(totalapp);
            papp.setText(totalappString);

        } else if (escolhaUsuario == "pedra" && escolhaApp == "tesoura" || escolhaUsuario == "papel" && escolhaApp == "pedra" || escolhaUsuario == "tesoura" && escolhaApp == "papel") {
            textoResultado.setText("   You Win   ");
            int soma = 1;
           //  int totalvoce = soma + pvoce; // pvoce is of TextView type, you need to get its text by getText(), convert it to String by .toString(), and then into int to make the integer addition valid
            int totalvoce = soma + Integer.parseInt(pvoce.getText().toString());

            String totalvoceString = Integer.toString(totalvoce);
            pvoce.setText(totalvoceString);
        }