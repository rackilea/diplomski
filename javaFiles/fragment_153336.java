public List<Person> querySearch(String snachname, String svorname, String srechtsform, String sadresse, String sort, String sland, String stelefon, String semail, LoadGroup group) {
        if(srechtsform.equals("Alle")) {
            srechtsform = "";
        }
        if(sland.equals("Alle")) {
            sland = "";
        }
        String q = "SELECT DISTINCT * FROM Person p LEFT OUTER JOIN Adresse a ON (a.PERSON_ID=p.ID) LEFT OUTER JOIN Telefon t ON (t.PERSON_ID=p.ID) LEFT OUTER JOIN Email e ON (e.PERSON_ID=p.ID) WHERE p.nachname1 LIKE '%"+snachname+"%'AND p.vorname LIKE '%"+svorname+"%' AND p.rechtsform LIKE '%"+srechtsform+"%' ";
        if(sadresse.equals("") && sort.equals("") && sland.equals("")) {
            q += "AND (a.ID IS NULL OR (a.strasse LIKE '%"+sadresse+"%' AND a.ort LIKE '%"+sort+"%' AND a.land LIKE '%"+sland+"%')) "; 
        } else {
            q += "AND a.strasse LIKE '%"+sadresse+"%' AND a.ort LIKE '%"+sort+"%' AND a.land LIKE '%"+sland+"%' "; 
        }
        if(stelefon.equals("")) {
            q += "AND (t.ID IS NULL OR t.nummer LIKE '%"+stelefon+"%') ";
        } else {
            q += "AND t.nummer LIKE '%"+stelefon+"%' ";
        }
        if(semail.equals("")) {
            q += "AND (e.ID IS NULL OR e.mailadresse LIKE '%"+semail+"%') ";
        } else {
            q += "AND e.mailadresse LIKE '%"+semail+"%' ";
        }
        q += "GROUP BY p.ID";
        Query query = em.createNativeQuery(q, Person.class);
        if(group!=null) { query.setHint(QueryHints.LOAD_GROUP, group); }
        return query.getResultList();
    }