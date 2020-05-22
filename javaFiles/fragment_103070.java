// Uncomment out on Java 6
    // import com.google.common.base.Joiner;

    List<String> clauses = new ArrayList<>();
    List<String> args = new ArrayList<>();

    if (StringUtils.isNotEmpty(projectId)) {
        clauses.add("UPPER(CIRC.PROJECT_ID) like ?");
        args.add(projectId);
    }

    if (StringUtils.isNotEmpty(circuitId)) {
        clauses.add("UPPER(CIRC.CIRCUIT_ID) like ?");
        args.add(circuitId);
    }

    if (StringUtils.isNotEmpty(orderRef)) {
        clauses.add("UPPER(CIRC.ORDERID) like ?");
        args.add(orderRef);
    }

    // Java 8 (comment out for Java 6)
    sql.append(clauses.stream().collect(Collectors.joining(" AND ")));

    // Uncomment for Java 6
    // sql.append(Joiner.on(" AND ").join(clauses));

    JSONArray jsonArray = new JSONArray();
    ResultSet rs = null;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    PreparedStatement ps = null;
    try {
        if (connection != null) {
            ps = connection.prepareStatement(sql.toString());
            for (int i = 0; i < args.size(); ++i) {
                ps.setString(i+1, "%" + args.get(i).toUpperCase() + "%");
            }
        }
    }