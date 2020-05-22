create type claim_bean as object (user_id number, claimant_id number);
/

create type claim_bean_tab as table of claim_bean;
/

create table tl_claims (claim_id number, claim_user_id number, claimant_id number)
/

create sequence seq_tb_claim;
/

create procedure p42(pt_claims in claim_bean_tab,
  po_claims_cursor out sys_refcursor)
as
  l_claim_ids sys.odcinumberlist;
begin
  forall i in 1..pt_claims.count
    insert into tl_claims(claim_id, claim_user_id, claimant_id)
    values (seq_tb_claim.nextval, pt_claims(i).user_id, pt_claims(i).claimant_id)
    returning claim_id bulk collect into l_claim_ids;

  open po_claims_cursor for
    select column_value from table(l_claim_ids);
end;
/

set serveroutput on
declare
  l_claims claim_bean_tab;
  l_claims_cursor sys_refcursor;
  l_claim_id tl_claims.claim_id%type;
begin
  l_claims := new claim_bean_tab();
  l_claims.extend(3);
  l_claims(1) := new claim_bean(42, 123);
  l_claims(2) := new claim_bean(57, 456);
  l_claims(3) := new claim_bean(13, 789);

  p42(l_claims, l_claims_cursor);
  loop
    fetch l_claims_cursor into l_claim_id;
    exit when l_claims_cursor%notfound;
    dbms_output.put_line('Got claim ID from cursor: ' || l_claim_id);
  end loop;
  close l_claims_cursor;
end;
/

select * from tl_claims
/

PL/SQL procedure successfully completed.

Got claim ID from cursor: 1
Got claim ID from cursor: 2
Got claim ID from cursor: 3