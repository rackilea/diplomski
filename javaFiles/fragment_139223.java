//Important that you don't interfer the Deactivate Action from useradmin
        //do nothing if the action is deactivate!
        if( !userNode.getProperty("cq:lastReplicationAction").getString().equals("Deactivate")) {
            activateNode(userNode, workflowSession, replicator);
            //save all changes
            session.save();
        }