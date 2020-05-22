{
   final {VariableModifierNoFinal} R Identifier = Expression; 
   Throwable #primaryExc = null;
   try ResourceSpecification_tail
      Block catch (Throwable #t) {
         #primaryExc = #t;
         throw #t;
      } finally {
         if (Identifier != null) {
            if (#primaryExc != null) { 
               try { 
                  Identifier.close(); 
               } catch (Throwable #suppressedExc) { 
                  #primaryExc.addSuppressed(#suppressedExc);
               }
            } else {
               Identifier.close();
            }
         }
     }
}