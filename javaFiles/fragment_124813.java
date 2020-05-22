int total = (train_ticket_amount == null || train_ticket_amount.equals("") ? 0:Integer.parseInt(train_ticket_amount))
                + (bus_ticket_amount == null || bus_ticket_amount.equals("")? 0:Integer.parseInt(bus_ticket_amount))
                + (bike_amount == null || bike_amount.equals("")? 0:Integer.parseInt(bike_amount))
                + (share_rickshaw_amount == null || share_rickshaw_amount.equals("")? 0:Integer.parseInt(share_rickshaw_amount));
        result = Integer.parseInt(textavailablebalance2) - total;


        if(!expense_amount.isEmpty())                
           result+=Integer.parseInt(expense_amount));
        textAvailableBalance1.setText(Integer.toString(result)); 

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("price", result);
        editor.apply();


        //second calculation
        amountused = (train_ticket_amount == null || train_ticket_amount.equals("") ? 0:Integer.parseInt(train_ticket_amount))+
                    (bus_ticket_amount == null || bus_ticket_amount.equals("")? 0:Integer.parseInt(bus_ticket_amount))+
                    (bike_amount == null || bike_amount.equals("")? 0:Integer.parseInt(bike_amount))+
                    (share_rickshaw_amount == null || share_rickshaw_amount.equals("")? 0:Integer.parseInt(share_rickshaw_amount));
        textfinalamount.setText(Integer.toString(amountused));
        amountused1 = textfinalamount.getText().toString();