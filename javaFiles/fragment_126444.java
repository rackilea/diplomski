String getUri;
        getUri = MessageFormat.format(GET_URL, HTTPS_GET_CUSTOMERS,
                QUANTITY + "", offset + "");

        credentials.initGetOAuthStructure(HTTPS_GET_CUSTOMERS);

        HttpGet request = new HttpGet(getUri + "&"
                + credentials.getOauthStructure());
        HttpResponse response = client.execute(request);

        Reader streamReader = new InputStreamReader(response
                    .getEntity().getContent());
        JsonReader reader = new JsonReader(streamReader);
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        reader.beginArray();
        while (reader.hasNext()) {
            Customer customer = new Customer();
            reader.beginObject();
            while (reader.hasNext()) {
                String name = reader.nextName();
                if (name.equals("Action")) {
                    customer.setAction(reader.nextString());
                } else if (name.equals("Addr1")) {
                    customer.setAddr1(reader.nextString());
                } else if (name.equals("Addr2")) {
                    customer.setAddr2(reader.nextString());
                } else if (//Other condition and value)
                    ...
                } else {
                    reader.skipValue();
                }
            }
            reader.endObject();
            customerList.add(customer);
        }
        reader.endArray();
        reader.close();