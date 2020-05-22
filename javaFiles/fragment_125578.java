private <F extends AbstractRule<T>, T> void applyRyle(F cRule, ArrayList<T> aFeatures)
{
     Class<? extends F> ruleType = cRule.getClass();
     // if the parameter passed is a subclass of AbstractRule create some objects
     if(! ruleType.getSuperclass().getName().equals("AbstractRule"))
     {
         ArrayList<? extends F> aRules = new ArrayList<? extends F>();
         for(int i = 0; i < 10; i++)
         {
             F aRule =
                 ruleType
                     .getConstructor(int.class, int.class, ArrayList.class)
                     .newInstance(pattern.getMatrices().size(), 2, aFeatures);
             aRule.initialise(aRule.getMaxLocalLevel());
             aRules.add(aRule);
         }
     }