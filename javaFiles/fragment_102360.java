create table bookkeepings (bk_name text primary key, bk_value integer not null);

insert or replace into bookkeepings values ('Max Results', 50);
insert or replace into bookkeepings values ('Qty Results', 0);

create table results
  (r_timestamp text primary key default (datetime(current_timestamp)),
   result text);

create trigger results_limit_trigger before insert on results"
  for each row"
  when (select bk_value from bookkeepings where bk_name = 'Qty Results')
    >= (select bk_value from bookkeepings where bk_name = 'Max Results')
  begin
    delete from results
      where r_timestamp = (select r_timestamp from results order by r_timestamp limit 1);
  end;

create trigger results_count_insert_trigger after insert on results
  for each row
  begin
    update bookkeepings set bk_value = bk_value + 1 where bk_name = 'Qty Results';
  end;

create trigger results_count_delete_trigger after delete on results
  for each row
  begin
    update bookkeepings set bk_value = bk_value - 1 where bk_name = 'Qty Results';
  end;