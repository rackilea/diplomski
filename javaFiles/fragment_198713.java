Disjunction disjunction = Restrictions.disjunction(); //OR condition

Conjunction conjunction1  = Restrictions.conjunction(); //AND condition
conjunction1.add(Restrictions.eq("doc.doctype", "passport"));
conjunction1.add(Restrictions.eq("doc.documentNo", "XXXX"));

Conjunction conjunction2  = Restrictions.conjunction(); //AND condition
conjunction2.add(Restrictions.eq("doc.doctype", "Driving License"));
conjunction2.add(Restrictions.eq("doc.documentNo", "YYYY"));

disjunction.add(conjunction1);
disjunction.add(conjunction2);