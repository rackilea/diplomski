PROCEDURE get_namelist
  (
    return_code_out OUT VARCHAR2,
    return_msg_out OUT VARCHAR2,
    id_no_in IN employee.id_no%TYPE,
    page_num IN (int datatype),              
    page_size IN (int datatype),             
    name_out OUT employee.name%TYPE,
       addr_out OUT employee.addr%TYPE,
  )
  IS

  BEGIN

    return_code_out := '0000';
    return_msg_out := 'OK';

    SELECT i.name, i.addr INTO name_out, addr_out, 
         FROM 
             (SELECT e.name, e.addr,
              ROW_NUMBER() OVER (ORDER BY e.name) as row           
              FROM employee e
              WHERE e.id_no = id_no_in) i
         WHERE row between ((page_num - 1) * page_size) AND (page_num * page_size);

END get_namelist;