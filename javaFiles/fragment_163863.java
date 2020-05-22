Client[] clientList;
int n=objDep.getNumberClients();
clientList=new Client[n];
for (int i=0;i<n;i++){
   clientList[i]=objDep.getClient(i).clone();
}