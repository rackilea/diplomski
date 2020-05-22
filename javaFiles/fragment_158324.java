private ValidBean isValidParam(SomeParameter sp) {
       if (sp == null) {
          return new ValidBean(false, new ParameterCannotBeNullException());
       }
       if (sp.getNonZeroInt() == 0) { 
         return new ValidBean(false, new ShouldBeNonZeroException());
       }
       if (!sp.someOtherCondition()) {
          return new ValidBean(false, new SomeConditionNotMetException());
       }
       …
       return new ValidBean(true, null);
    }