class Main {
    public static void main(String[] args) {
        List<ServerInfo> onlineServers = new ArrayList<ServerInfo>();
        ServerInfo si1 = new ServerInfo();
        ServerInfo si2 = new ServerInfo();
        ServerInfo si3 = new ServerInfo();
        si1.playerCount = 20;
        si2.playerCount = 10;
        si3.playerCount = 30;
        onlineServers.add(si1);
        onlineServers.add(si2);
        onlineServers.add(si3);
        ServerInfo elemWithMin = onlineServers.get(0);
        int min = onlineServers.get(0).playerCount;
        for (int i = 1; i < onlineServers.size(); i++) {
            if (onlineServers.get(i).playerCount < min) {
                min = onlineServers.get(i).playerCount;
                elemWithMin = onlineServers.get(i);
            }
        }
        System.out.println("The minimum value of payerCount: " + elemWithMin.playerCount);
    }
}