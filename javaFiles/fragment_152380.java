ModuleDirective:
     requires {RequiresModifier} ModuleName ;
     exports PackageName [to ModuleName {, ModuleName}] ;
     opens PackageName [to ModuleName {, ModuleName}] ;
     uses TypeName ;
     provides TypeName with TypeName {, TypeName} ;