SELECT b.id, l.libelle, p.libelle
  FROM FT_SEARCH_DATA(1, 0, 0) FT, ENREGISTREMENT b
   JOIN LIBELLE l on (b.id_libelle = l.id)
   JOIN MODEREGLEMENT p on (b.id_MODEREGLEMENT = p.id)
 WHERE b.id=FT.KEYS[0]
 AND FT.TABLE='ENREGISTREMENT' 
ORDER BY b.id;