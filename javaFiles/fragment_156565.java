@(instance: Superclass)

@main { 
  @instance match {
    case foo: Foo => {
      <a href="@routes.Foo.index()">@foo.title</a>
    }
    case bar: Bar => {
      <a href="@routes.Bar.index()">@bar.title</a>
    }
  }
}