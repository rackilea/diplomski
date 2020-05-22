public Criterion buildHibernateQuery(Query luceneQuery) {
    return parse(luceneQuery);
}

private Criterion parse(Query query) {
    if (query instanceof TermQuery) {
        return parse((TermQuery) query);
    } else if (query instanceof BooleanQuery) {
        return parse((BooleanQuery) query);
    } else if (query instanceof PhraseQuery) {
        return parse((PhraseQuery) query);
    } else if (query instanceof PrefixQuery) {
        return parse((PrefixQuery) query);
    } else if (query instanceof WildcardQuery) {
        return parse((WildcardQuery) query);
    } else {
        LOG.error(String.format("%s unsupported", query.getClass()));
    }
}

private Criterion parse(TermQuery query) {
    Term term = query.getTerm();
    return createNameValueRestriction(term.field(), term.text());
}

private Criterion parse(BooleanQuery query) {
    if (query.getClauses().length == 1) {
        return parse(query.getClauses()[0].getQuery());
    }
    Junction junction = createJunction(query.getClauses()[0]);

    for (BooleanClause clause: query.getClauses()) {
        junction.add(parse(clause.getQuery()));
    }
    return junction;
}

private Junction createJunction(BooleanClause booleanClause) {
    if (booleanClause.isRequired()) {
        return Restrictions.conjunction();
    } else {
        return Restrictions.disjunction();
    }
}

private Criterion parse(PhraseQuery query) {
    String field = query.getTerms()[0].field();
    StringBuilder phraseBuilder = new StringBuilder();
    for (Term term : query.getTerms()) {
        phraseBuilder.append(term.text());
        phraseBuilder.append(" ");
    }

    return createNameValueRestriction(field, phraseBuilder.toString().trim());
}

private Criterion createNameValueRestriction(String field, String value) {
    return Restrictions.and(
            Restrictions.eq("jsonPath", field),
            Restrictions.eq("answer", value)
            );
}

private Criterion parse(PrefixQuery query) {
    Term term = query.getPrefix();
    return parseLikeQuery(term.field(), term.text(), MatchMode.START);
}

private Criterion parse(WildcardQuery query) {
    Term term = query.getTerm();
    String wildCardEscaped = Pattern.quote(String.valueOf(WildcardQuery.WILDCARD_STRING));
    String termText = term.text().replaceAll(wildCardEscaped, "");
    return parseLikeQuery(term.field(), termText, MatchMode.ANYWHERE);
}


private Criterion parseLikeQuery(String field, String value, MatchMode matchMode) {
    return Restrictions.and(
            Restrictions.eq("jsonPath", field),
            Restrictions.like("answer", value, matchMode)
            );
}