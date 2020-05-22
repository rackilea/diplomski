// your own WHERE criteria:
Expression where = x("firstName = $1 and lastName = $2");

Statement statement =
    //this will produce the adequate SELECT..FROM.. clause:
    N1qlUtils.createSelectFromForEntity(template.getCouchbaseBucket().name())
    //use the DSL to continue to the WHERE clause
    .where(
        //this will produce the adequate WHERE criterias in addition to your own:
        //(see doc snippet for getting converter and entityInfo)
        N1qlUtils.createWhereFilterForEntity(where, converter, entityInfo));