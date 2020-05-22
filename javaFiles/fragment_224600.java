SpellChecker checker = new SpellChecker();

 SpellResponse spellResponse = checker.check( "helloo worlrd" );

 for( SpellCorrection sc : spellResponse.getCorrections() )
    System.out.println( sc.getValue() );