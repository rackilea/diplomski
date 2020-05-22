public <T extends Component> T addComponent(Class<T> clazz, T component) {

   if (containsComponent(clazz)) return null;

   components.put(clazz, component);
   return component;
}