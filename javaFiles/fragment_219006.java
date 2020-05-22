// Call update to give the item a last modified date. OK this isn't
    // amazingly efficient but creates don't happen that often.
    context.turnOffAuthorisationSystem();
    i.update();
    context.restoreAuthSystemState();

    context.addEvent(new Event(Event.CREATE, Constants.ITEM, i.getID(), 
            null, i.getIdentifiers(context)));