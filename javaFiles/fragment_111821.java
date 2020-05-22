This is the policy I have implemented. Code is not written in good optimized way but it is working. You can give it a try. This is mynewVmallocationpolicy. I think you can see what you have mistaken.

public boolean allocateHostForVm(Vm vm) {
        int requiredPes = vm.getNumberOfPes();
    //  int requiredram = vm.getRam();
        int freeramh1=0;
        int freeramh2=0;
        int freepesh1=0;
        int freepesh2=0;
        boolean result = false;
        int tries = 0;
        List<Integer> freePesTmp = new ArrayList<Integer>();
        for (Integer freePes : getFreePes()) {
            freePesTmp.add(freePes);
        }

        List <Host> hostList =getHostList();


        if (!getVmTable().containsKey(vm.getUid())) { // if this vm was not created
            do {// we still trying until we find a host or until we try all of them

                int idx = -1;

                // we want the host with less pes in use
                    Host h1=hostList.get(0);
                    int j=0;
                    idx=0;
                    for (int i = 1; i < freePesTmp.size(); i++) {
                        Host h2=hostList.get(i);
                        freeramh1=h1.getRamProvisioner().getAvailableRam();
                        freeramh2=h2.getRamProvisioner().getAvailableRam();
                        freepesh1=freePesTmp.get(j);
                        freepesh2=freePesTmp.get(i);
                    //  Log.printLine( " freeram "+ freeramh1 + "h2" + freeramh2 + "free pes " + freepesh1 + "h2" + freepesh2);
                        double diffram=0.0,diffpes=0.0;
                        if(freeramh2!=0 || freeramh1!=0){

                            diffram= (1.0*(freeramh2-freeramh1)/(freeramh2+freeramh1));

                        //  Log.printLine( " inside diffram " + diffram);
                        }
                        else
                            Log.printLine( " fault in ram " );
                        if(freepesh2!=0 || freepesh1!=0){
                            diffpes=(1.0*(freepesh1-freepesh2)/(freepesh1+freepesh2)) ;

                            //Log.printLine( " inside diffpes " + diffpes);
                        }
                        else
                            Log.printLine( " fault in pes ");

                        //Log.printLine( " diffram,diffpes "+ diffram + "diff pes " + diffpes );

                        if(diffram==diffpes || diffpes>diffram){
                            idx=j;  
                        }
                        else{
                            h1=h2;
                            j=i;
                            idx=i;
                            break;
                        }

                    }

                Host host = getHostList().get(idx);
                result = host.vmCreate(vm);

                if (result) { // if vm were succesfully created in the host
                    Log.printLine( " vm " +  "created" + "host" + idx);
                    getVmTable().put(vm.getUid(), host);
                    getUsedPes().put(vm.getUid(), requiredPes);
                    getFreePes().set(idx, getFreePes().get(idx) - requiredPes);
                    result = true;
                    break;
                } else {
                    freePesTmp.set(idx, Integer.MIN_VALUE);
                }
                tries++;
            } while (!result && tries < getFreePes().size());

        }

        return result;
    }