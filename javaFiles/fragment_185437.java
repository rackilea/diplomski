// I'm assuming DISTINCT is required here, as you
// - are not interested in TABLE_B and TABLE_C results (semi join semantics)
// - do not want any duplicate TABLE_A values
create.selectDistinct(TABLE_A.fields())
      .from(
          isFooSearched
        ? TABLE_A
             .join(TABLE_B).onKey(FK_TABLEA_TABLEB)
             .join(TABLE_C).onKey(FK_TABLEB_TABLEC)
          )
        : TABLE_A)
      .where(
          isFooSearched
        ? TABLE_C.FIELDC.containsIgnoreCase("foo")
        : trueCondition())
      .fetch();