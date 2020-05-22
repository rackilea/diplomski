Map<String, String> result = new HashMap<>();
Map<Integer, Map<String, String>> fr = new HashMap<>();

int i = 0;
try {

    ResultSet rq = qexec.execSelect();

    while (rq.hasNext()) {

        // Create your new HashMap inside the loop:
        result = new HashMap<>();

        QuerySolution soln = rq.next();

        id = soln.getLiteral("?id").getLexicalForm();
        //...

        result.put("id",id);
        //...

        if (soln.getLiteral("?wateruse") != null) {

            wateruse = soln.getLiteral("?wateruse").getLexicalForm();
            //...
            result.put("wateruse",wateruse);
        }
        else {
            System.out.println("NO");
        }               

        fr.put(i,result);
        i++;
    }
}