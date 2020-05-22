: numbers
  101 0 do
    i str$ portwrite
    portread type
  loop
;
"COM10" 9600 8 0 1 0  6 PORT a!
portopen
1500 sleep  (* 1 *)
numbers
portclose