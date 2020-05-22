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