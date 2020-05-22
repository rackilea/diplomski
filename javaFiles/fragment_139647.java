for ( Module module : modules ){
  if ( module.canHandle( messagePack ) ){
     module.handle( messagePack );
     //if messagePacks should only be handled by one module, break
  }
}