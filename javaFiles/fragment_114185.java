UPDATE PersonnelTable
SET FirstName = IF(? <> "", ?, FirstName),
    LastName = IF(? <> "", ?, LastName),
    Password = IF(? <> "", ?, Password),
    UserName = IF(? <> "", ?, UserName),
    Address = IF(? <> "", ?, Address)
WHERE IdNumber = ?;