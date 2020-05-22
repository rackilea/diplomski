SELECT ca
FROM Carte ca LEFT JOIN
     Compte c
     ON c = ca.compteid LEFT JOIN 
     Utilisateur u
     ON u.id = c.clientid AND u = :clientid;