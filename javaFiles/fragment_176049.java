for each row begin
    if new.expirydate < curdate() then
        set new.status = 1;  -- still active
    else set new.status = 0; -- expired
    end if;
end;