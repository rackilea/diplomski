Disjunction matchDisjunction = Restrictions.disjunction()
for(String keyword : keywords) {
            if(keyword != null && keyword.length() > 0) {
                matchDisjunction.add( Restrictions.like("lastName", keyword, MatchMode.ANYWHERE) );
                matchDisjunction.add( Restrictions.like("firstName", keyword, MatchMode.ANYWHERE) );
            }
        }
criteria.add(matchDisjunction);