// I'm assuming this static import
import static org.jooq.impl.DSL.*;

private String generateSQLWithWhereInInline(String... businessGroupProcesses) {
    Field<String>[] fields = new Field[businessGroupProcesses.length];
    for (int i = 0; i < businessGroupProcesses.length; i++)
        fields[i] = inline(businessGroupProcesses[i]);

    return DSL.using(SQLDialect.ORACLE)
              .selectDistinct(
                    field(name("Business Group")).as("Business_Group"))
              .from(table(name("SOME_TABLE")))
              .where(field(name("Business Group Process")).in(fields))
              .getSQL();
}