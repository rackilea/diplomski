SQL> select to_char(to_date(873,'J'), 'JSP') as converted_form from dual;

CONVERTED_FORM
---------------------------
EIGHT HUNDRED SEVENTY-THREE

SQL>
'JSP' means :
J : the Julian format.
SP : spells the word for the number passed to to_date