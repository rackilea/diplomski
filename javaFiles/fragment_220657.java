public void addPanel(JPanel jp)
{
    JPanel jp1=new JPanel();
    int i=jp.getComponentCount()-1;
    for(;i>=0;i--)
    {
         jp1.addComponent(
              ((Component) // this casts the clone back to component. This is maybe superfluous.
               ((Cloneable)jp.getComponent(i) // You have to ensure that all components that are returned are in fact instances of Cloneable.
               ).clone()
              ));
    }
    //after this I am setting bounds of jp1.
    this.add(jp1);
}