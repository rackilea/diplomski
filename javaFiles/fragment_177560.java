// Load the templating engine
load( "engine.js" );

// Read the template file
var template = readFile( "foo.template" ),

// Compile the template markup to JavaScript
compiled = engine.compile( template ),

// Un-evaluate the compiled template to text
code = uneval( compiled ),

// Create the file for the code
out = new java.io.FileWriter( "foo.js" );

// Write the code to the file
out.write( code, 0, code.length );
out.flush();
out.close();

quit();