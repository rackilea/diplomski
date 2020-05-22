SELECT ca.*
FROM Carte ca LEFT
-----------^
     Compte c
     ON c.compte_id = ca.compteid 
----------------------^ LEFT JOIN
     Utilisateur u
     ON u.id = c.clientid AND u.id = :clientid;
------------------------------^