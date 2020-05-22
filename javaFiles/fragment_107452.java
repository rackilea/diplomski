public static int getChildren(ASTNode node,int n) {
    int cont = n;
    String compara = "[]";

    List<ASTNode> children = new ArrayList<ASTNode>();
    @SuppressWarnings("rawtypes")
    List list = node.structuralPropertiesForType();

    for (int i = 0; i < list.size(); i++) {
        Object child = node.getStructuralProperty((StructuralPropertyDescriptor)list.get(i));
        if (child instanceof ASTNode) {
            children.add((ASTNode) child);
        }
    }

    String teste = children.toString();

    // Se a string do filho for igual a [] -> CHEGOU AO FIM 
    //e retorna resultado do contador para analyseClass
    if (teste.equals(compara)) {
        results.append("NMCS = "+cont+"\n");
        return cont;
    }

    // Aumenta o contador se o nó filho for MethodInvocation ou
    //SuperMethodInvocation
    if (node.getNodeType() == 32) {
        cont++;
    } else if (node.getNodeType() == 48) {
        cont++;
    }

    // Recursão para encontrar próximo nó (filho do filho)
    return getChildren(children.get(0),cont);}