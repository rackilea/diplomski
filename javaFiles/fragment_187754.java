ArrayList<Details> detailsArrayList = new ArrayList<>();
JsonArray jdetaul = response.body().get("data").getAsJsonArray();



for (int i = 0; i < jdetaul.size(); i++) {


    JsonObject object = jdetaul.get(i).getAsJsonObject();
    JsonArray jdetails = object.get("details").getAsJsonArray();


    for (int j = 0;j <jdetails.size();j++){
        JsonObject detailobj = jdetails.get(j).getAsJsonObject();
        Details details = new Details();
        details.setAddress(detailobj.get("address").getAsString());
        details.setSub_directory_name(detailobj.get("sub_directory").getAsString());



        JsonArray jemail = detailobj.get("email").getAsJsonArray();

        ArrayList<Email> emailArrayList = new ArrayList<>();
        for (int k = 0; k <jemail.size();k++){
            JsonObject emailobject = jemail.get(k).getAsJsonObject();
            Email email = new Email();
            email.setKey(emailobject.get("key").getAsString());
            email.setValue(emailobject.get("value").getAsString());
            details.setEmailArrayList(emailArrayList);
        }

        JsonArray jcontact_noarray = detailobj.get("contact_no").getAsJsonArray();

        ArrayList<ContactNo> contactNoArrayList = new ArrayList<>();
        for (int k = 0; k <jcontact_noarray.size();k++){

            JsonObject contactobj = jcontact_noarray.get(k).getAsJsonObject();
            ContactNo contactNo = new ContactNo();
            contactNo.setKey(contactobj.get("key").getAsString());
            contactNo.setValue(contactobj.get("value").getAsString());
            details.setContactNoArrayList(contactNoArrayList);
        }
        detailsArrayList.add(details);
    }

}