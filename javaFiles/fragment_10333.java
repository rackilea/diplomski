Stack<String> stack = Stack.ofType( String.class );
stack.push( "Hello" );
stack.push( "World" );

System.out.println( stack.size() );
System.out.println( stack.peek() );