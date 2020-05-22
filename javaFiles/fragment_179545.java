index = input.indexOf("-");

if(index == 0) {
    String substring = input.substring(input.lastIndexOf("-") + 1);
    newId = Integer.parseInt(substring);
    Store s  = new Store(name,id);