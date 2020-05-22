alter session set nls_timestamp_tz_format = 'YYYY-MM-DD HH24:MI:SS TZH:TZM';

with t (utc) as (
            select timestamp '1954-04-25 07:59:59 UTC' from dual
  union all select timestamp '1954-04-25 08:00:00 UTC' from dual
  union all select timestamp '1954-09-26 06:59:59 UTC' from dual
  union all select timestamp '1954-09-27 07:00:00 UTC' from dual
  --
  union all select timestamp '1955-04-24 07:59:59 UTC' from dual
  union all select timestamp '1955-04-24 08:00:00 UTC' from dual
  union all select timestamp '1955-10-30 06:59:59 UTC' from dual
  union all select timestamp '1955-10-30 07:00:00 UTC' from dual
  --
  union all select timestamp '1974-01-06 07:59:59 UTC' from dual
  union all select timestamp '1974-01-06 08:00:00 UTC' from dual
  union all select timestamp '1974-10-27 06:59:59 UTC' from dual
  union all select timestamp '1974-10-27 07:00:00 UTC' from dual
  --
  union all select timestamp '1975-02-23 07:59:59 UTC' from dual
  union all select timestamp '1975-02-23 08:00:00 UTC' from dual
  union all select timestamp '1975-10-26 06:59:59 UTC' from dual
  union all select timestamp '1975-10-26 07:00:00 UTC' from dual
  --
  union all select timestamp '1987-04-05 07:59:59 UTC' from dual
  union all select timestamp '1987-04-05 08:00:00 UTC' from dual
  union all select timestamp '1987-10-25 06:59:59 UTC' from dual
  union all select timestamp '1987-10-25 07:00:00 UTC' from dual
  --
  union all select timestamp '2007-03-11 07:59:59 UTC' from dual
  union all select timestamp '2007-03-11 08:00:00 UTC' from dual
  union all select timestamp '2007-11-04 06:59:59 UTC' from dual
  union all select timestamp '2007-11-04 07:00:00 UTC' from dual
)
select utc,
  utc at time zone 'America/Chicago' as chicago
from t;