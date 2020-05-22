select 'idPago','fecha','lead','idAlumno','idTipoPago','idGpo',
    'idTaller','idDocente','pagoImporte','NoFactura','facturaImporte',
    'mes','formaPago','observaciones' union all
(select id_control_pagos, fecha, lead, id_alumno, id_concepto_pago, id_Gpo,id_Taller,
    id_docente, Pagoimporte, NoFactura, FacturaImporte, Mensualidad_No, FormaPago,
    Observaciones from control_pagos
    into outfile 'c:\\data.csv'
    FIELDS TERMINATED BY ','
    OPTIONALLY ENCLOSED BY '"'
    LINES TERMINATED BY '\n');