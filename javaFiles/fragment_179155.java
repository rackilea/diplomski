ServerInfo elemWithMin = onlineServers.get(0);
int min = onlineServers.get(0).playerCount;
for(int i = 1; i < onlineServers.size(); i++) {
    if(onlineServers.get(i).playerCount < min) {
        min = onlineServers.get(i).playerCount;
        elemWithMin=onlineServers.get(i);
    }
}