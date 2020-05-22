SELECT 
    ir.id_receta
FROM 
    INGREDIENTES_RECETAS ir
WHERE 
    ir.id_ingrediente IN (89, 18)
GROUP BY 
    ir.id_receta
HAVING 
    COUNT(*) = 2;