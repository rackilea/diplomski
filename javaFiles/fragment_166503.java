declare
  arr_pn owa_util.vc_arr;
begin
  arr_pn(1):='12345';
  arr_pn(2):='678970';
  arr_pn(3):='5675675';
  LOC_MAINCLIENT.set_client_relations(id_account_ => 123,
    phone_number_list_ => arr_pn,
    dt_ => to_date('2013-03-24 21:54:00', 'YYYY-MM-DD HH24:MI:SS'));
end;