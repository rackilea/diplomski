int toSize=toMailIds.size();
InternetAddress[] address=new InternetAddress[toSize];

for (int i = 0; i < toSize; i++) {
    address[i] = new InternetAddress(toMailIds.get(i));
}