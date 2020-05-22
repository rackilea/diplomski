// ArrayList will be created only once for a json response.
    List<PaymentTiming_Items> getAllDiverDetails = new ArrayList<PaymentTiming_Items>();

  //Now parse add all elements in json response and add to list.
        for(all items in your jsonResponse List ) {    
            //Parse fields from json object
            String driver_fullname = json.getString("driver_fullname");
            String driver_phonenumber = json.getString("driver_phonenumber");
            String plate_no = json.getString("plate_no");
            String parking_name = json.getString("parking_name");

            //create object
            PaymentTiming_Items timingItems = new PaymentTiming_Items();
            timingItems.setPlateNo(plate_no);
            timingItems.setParkingName(parking_name);
            timingItems.setDriverFullName(driver_fullname);
            getAllDiverDetails.add(timingItems); // store all drivers' info to
        }

        //Now list will have all the items, Add this list to adapter.   
            if (getAllDiverDetails.size() !=0) {
            userList =  new ArrayList<>(getAllDiverDetails);
            listAdapter = new PaymentTiming_ListAdapter(getApplicationContext(), userList);
            myList.setAdapter(listAdapter);
            }