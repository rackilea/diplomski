@Override
public boolean isValid(Object object, final ConstraintValidatorContext c) {
   try {
      sessionFactory.getCurrentSession().setFlushMode(FlushMode.MANUAL);
      ...
   } finally {
      sessionFactory.getCurrentSession().setFlushMode(FlushMode.AUTO);
   }
}