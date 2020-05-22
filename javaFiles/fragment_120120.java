public <T,U> U ifElse( Supplier<Boolean> a, Supplier<U> ifTrue, Supplier<U> ifFalse) {
     if(a.get()) {
          return ifTrue.get();
     } else {
          return ifFalse.get();
     }
}

long lastPollTime = ifElse( () -> object == null, () -> object.getTime(), () -> 0);