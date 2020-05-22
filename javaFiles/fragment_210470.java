// the (String) cast may be unnecessary depending on your implementation
String device = (String) myAdapter.getAdapter().getItem(myItemInt);
String[] nameAndAddress = device.split("\n");

String name = nameAndAddress[0];
String macAddress = nameAndAddress[1];