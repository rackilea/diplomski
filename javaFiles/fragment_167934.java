Map<Class<? extends Foo>, FooHandler> map ...

map.put( Foo.class, new FooHandler() );
map.put( ImprovedFoo.class, new ImprovedFooHandler() );

Foo foo ...; // here comes an unknown foo 

map.get( foo.getClass() ).handleFoo( foo );