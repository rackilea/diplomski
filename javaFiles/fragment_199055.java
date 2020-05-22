List<String> strings = new ArrayList<String>();
while(rs.next()){

     strings.add(rs.getString("Name"));  // Confirm if "Name" is valid


    }
cbox.addItem(strings);