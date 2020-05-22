// Assuming this static import:
import static org.jooq.impl.DSL.*;

Map<String, Integer> map1 =
ctx.select(BOOKTABLE.TYPE, count())
   .from(BOOKTABLE)
   .groupBy(BOOKTABLE.TYPE)
   .fetchMap(BOOKTABLE.TYPE, count());