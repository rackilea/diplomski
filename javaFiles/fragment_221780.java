callableStatement.executeQuery();

// The first 3 elements are not OUT parameters (I guess)
List<String> values = Arrays.asList(tin, branchCode, rdoCode);

for (int i = 4; i <= 27; i++) {
    values.add(callableStatement.getString(i));
}

System.out.println("The list: " + values.toString);