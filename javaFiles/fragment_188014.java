ExecutionResult result = graphQL.execute("{books(first:10, after:\"20\") {" +
                "   pageInfo {" +
                "       hasNextPage" +
                "   }," +
                "   edges {" +
                "       cursor, node {" +
                "           title" +
                "}}}}");