package HelloWorld;
use Moose;

sub say_hello {
   print "Hello";
}

1;

package HelloWorldScriptService;
use Moose;

has 'hello_world' => ( is => 'rw', isa => 'HelloWorld' );

# TODO - will need to instantiate the hello_world object somewhere...

sub greet {
   my ($self) = @_;
   return $self->hello_world->say_hello();
}

1;