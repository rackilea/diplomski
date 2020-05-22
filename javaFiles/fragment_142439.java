ASTRewrite rewrite = ASTRewrite.create( ast );

            astRoot.recordModifications();

            // for getting insertion position
            TypeDeclaration typeDecl = (TypeDeclaration) astRoot.types()
                    .get(0);
            MethodDeclaration methodDecl = typeDecl.getMethods()[0];

            Block block = methodDecl.getBody();


            ListRewrite paramRewrite = rewrite.getListRewrite( methodDecl ,
                    MethodDeclaration.PARAMETERS_PROPERTY);


            ListRewrite listRewrite = rewrite.getListRewrite( block ,
                    Block.STATEMENTS_PROPERTY );

            List<SingleVariableDeclaration> paramList = new ArrayList<SingleVariableDeclaration>();

            List<VariableDeclarationStatement> varDeclarations =  classVisitor.getReplaceableVardDeclarationNodes();

            for( VariableDeclarationStatement statement : varDeclarations ){


                List<VariableDeclarationFragment> fragments = statement.fragments();

                for( VariableDeclarationFragment fragment : fragments){

                    IVariableBinding varBinding = fragment.resolveBinding();

                    System.out.println("Will replace node with var name :"+ varBinding.getName() +", of type :"+varBinding.getType().getQualifiedName());


                    SingleVariableDeclaration singleVariableDeclaration = ast.newSingleVariableDeclaration();
                    singleVariableDeclaration.setType(ast.newPrimitiveType(PrimitiveType.toCode(varBinding.getType().getQualifiedName())));
                    singleVariableDeclaration.setName(ast.newSimpleName(varBinding.getName()));

                    paramRewrite.insertLast( singleVariableDeclaration, null);


                }

                listRewrite.remove(statement, null);


            }


            TextEdit edits = rewrite.rewriteAST(document, null);