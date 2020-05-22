SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");

for (CreditCard cc : credit1)
    {

        out.println(cc.getNumber() + "\t");
        out.print(sf.format(cc.getExpiryDate()));

    }