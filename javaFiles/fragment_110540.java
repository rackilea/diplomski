PrintWriter deserialize() {
    PrintWriter obj = new PrintWriter("/tmp/Hacked.txt");
    obj.println("You have been hacked!");
    obj.close();
    return obj;
}