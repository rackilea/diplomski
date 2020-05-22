class Servidor {
    SharedValues sharedValues = SharedValues.getInstance();

    //make sure this while loop code is in a function
    while(true)
    {
        if (numero == capicuar(numero)) {
            sharedValues.setCapicua(false);

        }
    }
}


class Client {
    SharedValues sharedValues = SharedValues.getInstance();

    //make sure this while loop code is in a function
    while(true)
    {
        boolean capicua = sharedValues.getCapicua();
        System.out.println(capicua);
    }
}