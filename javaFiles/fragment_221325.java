private static ArrayList<String> getHypernymTerm( PointerTargetNodeList ptnl,
                                                        ArrayList<String> parent2, String str )  
            throws JWNLException{
      ArrayList<String> parent = parent2;
      if ( !str.equals("entity") ) {
        for (Iterator<?> itr = ptnl.iterator(); itr.hasNext();) {
          PointerTargetNode node = (PointerTargetNode) itr.next();
          Synset synset = node.getSynset();
          String term = synset.getWord(0).getLemma();
          parent.add(term);
          PointerTargetNodeList targets = new PointerTargetNodeList(synset.getTargets(PointerType.HYPERNYM) );
      if (targets.size() > 0) {
            parent = getHypernymTerm( targets, parent, term);
            }
        }

      }
      return parent;
    }