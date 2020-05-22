enum Item {
  ONE {
    @Override A getObject(MyComponent component) {
      return component.getA();
    } 
  },
  TWO {
    @Override B getObject(MyComponent component) {
      return component.getB();
    }
  };

  abstract Object getObject(MyComponent component);
}