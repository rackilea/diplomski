public boolean visit(VariableDeclarationFragment node) {
                    SimpleName name = node.getName();
                    System.out.println("Declaration of '"+name+"' at line"+cu.getLineNumber(name.getStartPosition()));

                    int modifiers = 0;
                    if (node.getParent() instanceof FieldDeclaration){
                        modifiers = ((FieldDeclaration)node.getParent()).getModifiers();
                    }
                    else if (node.getParent() instanceof VariableDeclarationStatement){
                        modifiers = ((VariableDeclarationStatement)node.getParent()).getModifiers();
                    }
                    return false; 
                }