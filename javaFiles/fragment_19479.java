while (nextCustomer != null) {
        if (position == nextTe.getPositionInVehicleChain()) break;
        scoreDirector.beforeVariableChanged(nextCustomer, "position");
        nextCustomer.setPositionInStapelabschnitt(pos);
        scoreDirector.afterVariableChanged(nextCustomer, "position");
        pos++;
        nextCustomer = nextCustomer.getNextCustomer();  
    }