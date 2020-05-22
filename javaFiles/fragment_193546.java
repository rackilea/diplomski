@Factory
    public Query getFilter() {

        BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();

        String fieldId = "info.breed.name";

        //booleanQuery.setMinimumNumberShouldMatch(1);
        for (String breed : breeds) {

            if(breed.contains(" ")) { // if multiple terms in breed
                PhraseQuery.Builder builder = new PhraseQuery.Builder();

                String[] terms = breed.split(" ");

                for (int i = 0; i < terms.length; i++) {
                    builder.add(new Term( fieldId, terms[i].toLowerCase() ), i);
                }

                PhraseQuery pq = builder.build();

                BooleanClause clause = new BooleanClause(pq, Occur.SHOULD);
                booleanQuery.add(clause);
            }else {
                // single term
                BooleanClause clause = new BooleanClause(new TermQuery( new Term(fieldId, breed.toLowerCase() ) ), Occur.SHOULD);
                booleanQuery.add(clause);
            }


        }

        BooleanQuery query = booleanQuery.build();
        return query;
    }