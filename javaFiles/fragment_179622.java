boolean noLoss=false;
for(int j=0;j<4;j++){
    if(currentState[j][0]==4)
        continue; //if current server has no vms free, chck the next server
    else{
        currentState[j][0]++;
        noLoss=true; //the package was able to arrive to a server
        break; //we don't need to check any other server, since the package arrived
    }
}
if(!noLoss)
    loss++; //the package couldn't find a free server, hence it is a loss
arrived++;