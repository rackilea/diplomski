load = 60;  
do forever
  time = current_system_time_ms() + load
  while (current_system_time_ms() < time)
     // just consume some time for 60 ms 
  end

  SLEEP(100 - load);  // sleep for 40 ms
end