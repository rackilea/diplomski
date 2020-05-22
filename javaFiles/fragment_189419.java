return triples.stream().filter(st -> 
          {
              if (prop.equals(st.getPredicate()) {
                   // add this triple if its subject has the correct type
                   return triples.contains(st.getSubject(), RDF.TYPE, c));
              } else if (RDF.TYPE.equals(st.getPredicate()) 
                          && c.equals(st.getObject()) {
                   // add this triple if its subject has the correct prop
                   return triples.contains(st.getSubject(), prop, null);
              }
              return false;
          }).collect(Collectors.toCollection(LinkedHashModel::new));