UIViewRoot viewRoot = context.getViewRoot();
PartialViewContext partialViewContext = facesContext.getPartialViewContext();
Set<EditableValueHolder> inputs = new HashSet<EditableValueHolder>();

// First find all to be rendered inputs and add them to the set.
findAndAddEditableValueHolders(partialViewContext.getRenderIds(), inputs);

// Then find all executed inputs and remove them from the set.
findAndRemoveEditableValueHolders(partialViewContext.getExecuteIds(), inputs);

// The set now contains inputs which are to be rendered, but which are not been executed. Reset them.
for (EditableValueHolder input : inputs) {
    input.resetValue();
}