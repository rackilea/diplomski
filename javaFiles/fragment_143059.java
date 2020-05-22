class Foo
{
  public Foo()
  {
    new ActionListener()
    {
      @Override
      public void actionPerformed(final ActionEvent e)
      {
        Foo thisFoo = Foo.this;
      }
    };
  }
}