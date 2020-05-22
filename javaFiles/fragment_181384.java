select Email_Address
from eloqua_export
where Email_Address not in (select Email_Address
                            from eloqua_export_duplicate);
select Email_Address
from eloqua_export_duplicate
where Email_Address not in (select Email_Address
                            from eloqua_export);