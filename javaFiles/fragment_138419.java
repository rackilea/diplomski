CREATE OR REPLACE FUNCTION order_func(anyarray) RETURNS anyarray AS $BODY$ 
     BEGIN
        return ARRAY(SELECT unnest($1) ORDER BY 1);
     END;
$BODY$ LANGUAGE 'plpgsql';

CREATE AGGREGATE array_agg_order_func(anyelement) (
SFUNC=array_append,
STYPE=anyarray,
FFUNC=order_func,
INITCOND='{}'
);