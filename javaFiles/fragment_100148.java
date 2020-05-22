public Action3d getAction(){
        SequenceAction action = new SequenceAction();

        for(Vector3 pos : playerStation.getPath()){
            action.addAction(Actions3d.moveTo(pos.x, pos.y, pos.z, 5));
        }
        return action;
    }