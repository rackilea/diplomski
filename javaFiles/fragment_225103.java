LinkedList<String> dynMachine = holder.get(machine.getDatacenter());
    if (dynMachine == null) {
      dynMachine = new LinkedList<String>();
      holder.put(machine.getDatacenter(), dynMachine);
    }
    dynMachine.add(machine.getDatacenter());