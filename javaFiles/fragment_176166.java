for (INode x : parseResult.getRootNode().getLeafNodes()) {
            if (x.getStartLine()==e.getStartLine()) {
                System.out.print(x.getText());
            }
        }
        System.out.println();