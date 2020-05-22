DROP SEQUENCE sf.mastercase;

-- the following uses the above function to set the starting value of a new sequence based on the last used
-- in the widget table
select sf.start_mc((select substring("widgetId",4)::integer + 1 from widgets
where "widgetId" like 'MC-%'
order by "widgetId" desc
limit 1));