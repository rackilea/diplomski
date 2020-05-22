// Static imports are assumed to be present:
import static org.jooq.impl.DSL.*;

DSLContext ctx = using(configuration);

// Solution 1) Coerce Field<Boolean> to Field<Number>
ctx.select(count(), sum(field(TABLE1.VALUE.gt(100)).coerce(Integer.class)))
   .from(TABLE1)
   .fetch();

// Solution 2) Resort to a raw type cast
ctx.select(count(), sum((Field) field(TABLE1.VALUE.gt(100))))
   .from(TABLE1)
   .fetch();