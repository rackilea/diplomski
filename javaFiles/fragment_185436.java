create.select()
      .from(TABLE_A)
      .where(
          isFooSearched
        ? TABLE_A.TABLE_B_ID.in(
              select(TABLE_B.ID)
             .from(TABLE_B)
             .join(TABLE_C).onKey(FK_TABLEB_TABLEC)
             .where(TABLE_C.FIELDC.containsIgnoreCase("foo"))
          )
        : trueCondition())
      .fetch();