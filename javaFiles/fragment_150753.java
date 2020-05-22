create or replace function to_date_safe(p_datestr varchar2) return date
as
    l_result date;

    invalid_day_for_month exception;
    pragma exception_init(invalid_day_for_month, -1847);
    pragma udf;
begin
    begin
        l_result := to_date(p_datestr,'YYYYMMDD');
    exception
        when invalid_day_for_month then
            l_result := last_day(to_date(substr(p_datestr,1,6),'YYYYMM'));
    end;

    return l_result;
end to_date_safe;