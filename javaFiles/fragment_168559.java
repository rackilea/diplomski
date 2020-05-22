// add the area filtering listener that generates specific area HTML only
LinkedList<AbstractRenderingListener> listeners = new LinkedList<>();
listeners.add(areaFilteringListener);
renderingEngine.setListeners(listeners);

// we need to provide the exact same Response instance that the WebContext is using
// otherwise the voters against the AreaFilteringListener will skip the execution
renderingEngine.initListeners(outputProvider, MgnlContext.getWebContext().getResponse());