if (actions.size() > 0) {
    for (int i = 0; i < actions.size(); i++) {

        if (actions.get(i).getRemoteInputs()[0] == null) {
            flag = 0;
            break;
        }

        if (!actions.get(i).getRemoteInputs()[0].getLabel().equals(wearableExtender.getActions().get(0).getRemoteInputs()[0].getLabel())) {
            flag = 1;
        } else {
            flag = 0;
            break;
        }
    }
} else{
    actions.addAll(wearableExtender.getActions());
}