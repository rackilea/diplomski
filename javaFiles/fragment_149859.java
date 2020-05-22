Constraint relaxation = new Constraint();
relaxation.setName(Constraint.ANY_ROLE);
relaxation.setAuthenticate(false);

ConstraintMapping rm = new ConstraintMapping();
rm.setConstraint(relaxation);
rm.setPathSpec("/signup");