private View.OnClickListener myListener = new View.OnClickListener() {
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
                emailIntent.setType("message/rfc822"); //specifies message for email app.
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"my_email@gmail.com"} );
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Заявка на замер");


                String body ="Имя клиента: " + getOrderName()+"\n"+
                             "Номер телефона : " + getOrderPhone()+"\n"+
                             "Адрес : " + getOrderAdress()+"\n"+
                             "Дата : " + getOrderDate()+"\n"+
                             "Удобное время : " + getOrderTime();
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, body);
                startActivity(Intent.createChooser(emailIntent, "Выберите почтовый сервис"));


            }
    };