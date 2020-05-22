ArrayList<IPAddress> addresses = new ArrayList<>();
addresses.add(new IPAddress("8.8.8.8"));
addresses.add(new IPAddress("198.252.206.16"));

IPAddress mask = new IPAddress("20-200.200-255.100-255.0-255");
for (IPAddress addr : addresses){
    if (mask.hasMatchOf(addr)){
        ...
    }else{
        ..
    }
}