SELECT ca
FROM Carte ca LEFT JOIN
     Compte c
     ON c = ca.compteid LEFT JOIN
     Utilisateur u
     ON u = c.clientid
WHERE u.id = :clientid;