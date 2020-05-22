RepositoryConnection conn = repo.getConnection();
  try {
     RepositoryResult<Statement> idStatementIter =
              conn.getStatements(null,
                  RepositoryConfigSchema.REPOSITORYID, null,
                  true, new Resource[0]);

    (... do something with the result here ...)
  }
  finally {
    conn.close();
  }