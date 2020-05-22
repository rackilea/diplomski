Map<Class<? extends AbstractTool>, AbstractTool> ToolMap = new HashMap<Class<? extends AbstractTool>, AbstractTool>();

  @SuppressWarnings("unchecked")
  public <T extends AbstractTool> T getTool(Class<T> cls){
    if (ToolMap.containsKey(cls)) {
        return (T) ToolMap.get(cls);
    }
    else return null;
  }