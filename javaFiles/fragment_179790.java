while ((inputLine = in.readLine()) != null) {
        //this line must not be here inputLine = in.readLine();
        System.out.println(inputLine);
        Item x = new Item(inputLine);
        itemList.add(x);
    }