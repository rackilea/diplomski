Object[] data = new Object[clientList.size()+1];
data[0] = "CLIENTS";
int counter = 1;
for(TableUser tu: clientList) {
    data[counter] = tu;
    counter++;
}