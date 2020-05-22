Disjunction matchDisjunction = Restrictions.disjunction()
for(String keyword : keywords) {
            if(keyword != null && keyword.length() > 0) {
                matchDisjunction.add(
                        Restrictions.or(
                            Restrictions.like("lastName", keyword, MatchMode.ANYWHERE), 
                            Restrictions.like("firstName", keyword, MatchMode.ANYWHERE)
                        ));
            }
        }
criteria.add(matchDisjunction);