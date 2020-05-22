globals [
  ;; your model globals here

  output-variables
]

to setup
  clear-all

  ;;; your model setup code here

  file-open "my-output.csv"
  ; the given variables should be valid reporters for the NetLogo model
  set output-variables [ "ticks" "current-price" "number-of-residences" "count-years-simulated" "solar-PV-cost" "%-lows" "k" ]
  file-print csv:to-row output-variables

  reset-ticks
end

to go
  ;;; the rest of your model code here

  file-print csv:to-row map [ v -> runresult v ] output-variables
  file-flush
  tick
end