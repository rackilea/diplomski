-- Convert numeric to bit
CREATE OR REPLACE FUNCTION numeric_to_bit(NUMERIC)
  RETURNS BIT VARYING AS $$
DECLARE
  num ALIAS FOR $1;
  -- 1 + largest positive BIGINT --
  max_bigint NUMERIC := '9223372036854775808' :: NUMERIC(19, 0);
  result BIT VARYING;
BEGIN
  WITH
      chunks (exponent, chunk) AS (
        SELECT
          exponent,
          floor((num / (max_bigint ^ exponent) :: NUMERIC(300, 20)) % max_bigint) :: BIGINT
        FROM generate_series(0, 5) exponent
    )
  SELECT bit_or(chunk :: BIT(300) :: BIT VARYING << (63 * (exponent))) :: BIT VARYING
  FROM chunks INTO result;
  RETURN result;
END;
$$ LANGUAGE plpgsql IMMUTABLE;

-- conversion for bit(8) to integer with sign
CREATE OR REPLACE FUNCTION bit_to_integer(b BIT(8))
  RETURNS INTEGER  AS $$
DECLARE
  result int;
BEGIN
  result := b::integer;
  result := case when result > 127 then result-256 else result end;
  RETURN result;
END;
$$ LANGUAGE plpgsql IMMUTABLE;

-- removce padding from bit varying
CREATE OR REPLACE FUNCTION ltrim_bitvar(bv BIT VARYING)
  RETURNS text  AS $$
DECLARE
  result text;
  fill int;
BEGIN
  result := ltrim(bv::text,'0');
  fill := 8-length(result)%8;
  result := lpad(result,length(result)+fill,'0') ;
  return result;
END;
$$ LANGUAGE plpgsql IMMUTABLE;

--converting bit var text to byte array
CREATE OR REPLACE FUNCTION btext_to_bytea(b text)
  RETURNS bytea AS
$BODY$
DECLARE
  bytes bytea;
  temp integer;
  b_len integer;
BEGIN
  b_len := length(b)/8;
  bytes = lpad('',b_len,'0')::bytea;
  for i in 1..b_len loop
   temp = substring(b,(i*8)-8 + 1,8)::bit(8)::integer;
   --raise notice '%', temp;
   bytes := set_byte(bytes, i-1, temp);
  end loop;
  return bytes;

END;
$BODY$
  LANGUAGE plpgsql IMMUTABLE;

-- converting numeric to bytea
CREATE OR REPLACE FUNCTION num_to_bytea(n numeric)
  RETURNS bytea AS
$BODY$

BEGIN
 return btext_to_bytea(ltrim_bitvar(numeric_to_bit(n)));
END;
$BODY$
  LANGUAGE plpgsql IMMUTABLE;